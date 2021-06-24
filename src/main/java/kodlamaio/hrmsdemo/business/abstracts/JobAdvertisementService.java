package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertisementDto;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertisementRequestDto;


import java.sql.Date;
import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisementDto>> getAllAd();
    DataResult<JobAdvertisementRequestDto> addAd(JobAdvertisementRequestDto jobAdvertisement);


    DataResult<List<JobAdvertisementDto>> getActive();
    DataResult<List<JobAdvertisementDto>>findAllByActiveFalseOrderByCreatedAtDesc();
    DataResult<List<JobAdvertisementDto>> getEmpId(int id);
    DataResult<List<JobAdvertisementDto>> getAdDate();
    DataResult<List<JobAdvertisementDto>> getAdCustomDate(Date date);
    DataResult<List<JobAdvertisementDto>> findAll(int pageNo,int pageSize);
    DataResult<JobAdvertisement> updateActive(int id, boolean active);

}


