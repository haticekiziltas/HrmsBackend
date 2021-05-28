package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Candidate;

import java.util.List;

public  interface CandidateService {

    DataResult<List<Candidate>> getAll();
    Result add (Candidate candidate) throws Exception;
}
