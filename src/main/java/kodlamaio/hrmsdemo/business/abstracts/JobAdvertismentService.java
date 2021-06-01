package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.JobAdvertisment;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertismentDetailsDto;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertismentRequestDto;


import java.sql.Date;
import java.util.List;

public interface JobAdvertismentService {

    Result add(JobAdvertismentRequestDto jobAdvertisment);
    Result update(JobAdvertisment jobAdvertisment);

    DataResult<List<JobAdvertismentDetailsDto>> getAll();
    DataResult<List<JobAdvertismentDetailsDto>> getJobAdvertiseWithEmployerDetails();
    DataResult<List<JobAdvertisment>> getAllByApplicationDeadline(Date date);
    DataResult<List<JobAdvertisment>> getAllByEmployer(int employerId);
    DataResult<List<JobAdvertisment>> getAllByDateDesc();
    DataResult<JobAdvertisment> updateActive(int id, boolean active);

}

