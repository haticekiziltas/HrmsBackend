package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.EmployerService;
import kodlamaio.hrmsdemo.business.abstracts.ValidationService;
import kodlamaio.hrmsdemo.core.utilities.results.*;
import kodlamaio.hrmsdemo.core.utilities.validations.Validations;
import kodlamaio.hrmsdemo.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsdemo.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    @Autowired
    private EmployerDao employerDao;
    @Autowired
    private ValidationService validationService;

    public EmployerManager(EmployerDao employerDao, ValidationService validationService) {
        this.employerDao = employerDao;
        this.validationService = validationService;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler Listelendi");
    }

    @Override
    public Result add(Employer employer) throws NullPointerException {
        var result = Validations.run(validationService.requiredEmployer(employer),validationService.mailExistEmployer(employer));
        if (result!= null) {
            return result;
        }else{
            employerDao.save(employer);
            return new SuccessResult("Başarılı Ekleme");
        }

    }
}
