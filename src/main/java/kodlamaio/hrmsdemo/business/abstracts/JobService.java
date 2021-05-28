package kodlamaio.hrmsdemo.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Job;

public interface JobService {

    DataResult<List<Job>> getAll();

    DataResult<Optional<Job>> getById(int id);
    Result add(Job job);
}
