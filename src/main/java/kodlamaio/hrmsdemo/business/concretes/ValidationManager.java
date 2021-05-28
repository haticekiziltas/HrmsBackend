package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.adapters.abstracts.IdentityCheckService;
import kodlamaio.hrmsdemo.business.abstracts.ValidationService;
import kodlamaio.hrmsdemo.core.utilities.results.ErrorResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrmsdemo.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsdemo.dataAccess.abstracts.UserDao;
import kodlamaio.hrmsdemo.entities.concretes.Candidate;
import kodlamaio.hrmsdemo.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationManager implements ValidationService {
    private EmployerDao employerDao;
    private IdentityCheckService<Candidate> identityCheckService;


    @Autowired
    public ValidationManager(EmployerDao employerDao, IdentityCheckService<Candidate> identityCheckService) {
        this.employerDao = employerDao;
        this.identityCheckService = identityCheckService;
    }

    @Autowired
    private CandidateDao candidateDao;
    @Autowired
    private UserDao userDao;

    public ValidationManager(CandidateDao candidateDao, UserDao userDao) {
        this.candidateDao = candidateDao;
        this.userDao = userDao;
    }


    @Override
    public Result mailIdentityExist(Candidate candidate) throws Exception {
        if (this.userDao.existsByEmailAdress(candidate.getEmailAdress())) {
            return new ErrorResult("Email Adresi Kayıtlı");
        } else if (this.candidateDao.existsByIdentificationNumber(candidate.getIdentificationNumber())) {
            return new ErrorResult("Tc No Kayıtlı");
        }


        return new SuccessResult();
    }


    @Override
    public Result mailExistEmployer(Employer employer) {
        if (!this.employerDao.existsEmployerByEmailAdress(employer.getEmailAdress())) {
            return new SuccessResult();

        } else {
            return new ErrorResult("Kayıtlı Email");
        }
    }

    @Override
    public boolean validEmailEmp(Employer employer) {
        return false;
    }

    @Override
    public boolean validEmailCan(Candidate candidate) {
        return true;
    }

    @Override
    public Result mernisCandidate(Candidate candidate) throws Exception {
        if (identityCheckService.validate(candidate)) {
            return new SuccessResult();
        } else {

            return new ErrorResult("Tc kimlik doğrulaması başarısız");
        }
    }


    @Override
    public Result requiredEmployer(Employer employer) {
        if (employer.getCompanyName() == null || employer.getCompanyName().isBlank() || employer.getWebAddress() == null || employer.getWebAddress().isBlank() || employer.getEmailAdress() == null || employer.getEmailAdress().isBlank() || employer.getPassword() == null || employer.getPassword().isBlank()) {
            return new ErrorResult("Tüm Alanları Doldurunuz");
        } else {

            return new SuccessResult();
        }

    }

    @Override
    public Result requiredCandidate(Candidate candidate) {
        if (candidate.getFirstName() == null || candidate.getFirstName().isBlank() || candidate.getLastName() == null || candidate.getLastName().isBlank() || candidate.getEmailAdress() == null || candidate.getEmailAdress().isBlank() || candidate.getBirthDate() == null && candidate.getIdentificationNumber() == null || candidate.getIdentificationNumber().isBlank() || candidate.getPassword() == null || candidate.getPassword().isBlank()) {
            return new ErrorResult("Tüm Alanları doldurunuz");

        } else {
            return new SuccessResult();
        }
    }

}