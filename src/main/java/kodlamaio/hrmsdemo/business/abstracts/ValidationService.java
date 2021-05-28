package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Candidate;
import kodlamaio.hrmsdemo.entities.concretes.Employer;

public interface ValidationService {
    Result mailIdentityExist(Candidate candidate) throws Exception;
    Result mailExistEmployer(Employer employer);
    boolean validEmailEmp(Employer employer);
    boolean validEmailCan(Candidate candidate);
    Result mernisCandidate(Candidate candidate) throws Exception;
    Result requiredEmployer(Employer employer);
    Result requiredCandidate(Candidate candidate);

}
