package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.JobAdvertise;


import java.sql.Date;
import java.util.List;

public interface JobAdvertiseService {
    Result add(JobAdvertise jobAdvertise);

    Result update(JobAdvertise jobAdvertise);

    DataResult<List<JobAdvertise>> getAll();

    DataResult<List<JobAdvertise>> getAllByApplicationDeadline(Date date);

    DataResult<List<JobAdvertise>> getAllByEmployer(int employerId);
    DataResult<JobAdvertise> updateActive(int id,boolean active);
}

