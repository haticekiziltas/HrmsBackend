package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.JobAdvertise;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertiseDetailsDto;


import java.sql.Date;
import java.util.List;

public interface JobAdvertiseService {

    Result add(JobAdvertise jobAdvertise);
    Result update(JobAdvertise jobAdvertise);

    DataResult<List<JobAdvertise>> getAll();
    DataResult<List<JobAdvertiseDetailsDto>> getJobAdvertiseWithEmployerDetails();
    DataResult<List<JobAdvertise>> getAllByApplicationDeadline(Date date);
    DataResult<List<JobAdvertise>> getAllByEmployer(int employerId);
    DataResult<List<JobAdvertise>> getAllByDateDesc();
    DataResult<JobAdvertise> updateActive(int id,boolean active);

}

