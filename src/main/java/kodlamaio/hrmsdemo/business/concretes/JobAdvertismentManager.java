package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.JobAdvertismentService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.JobAdvertismentDao;
import kodlamaio.hrmsdemo.entities.concretes.JobAdvertisment;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertismentDetailsDto;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertismentRequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobAdvertismentManager implements JobAdvertismentService {
    private JobAdvertismentDao jobAdvertismentDao;
    private ModelMapper modelMapper;



    @Autowired
    public JobAdvertismentManager(JobAdvertismentDao jobAdvertismentDao) {
        super();
        this.jobAdvertismentDao = jobAdvertismentDao;



    }
    @Override
    public Result add(JobAdvertismentRequestDto jobAdvertisment) {
        JobAdvertisment jobAdvertisements = modelMapper.map(jobAdvertisment,JobAdvertisment.class);
        jobAdvertismentDao.save(jobAdvertisements);
        return new SuccessDataResult<JobAdvertismentRequestDto>(jobAdvertisment," ilan oluşturuldu");
    }

    @Override
    public Result update(JobAdvertisment jobAdvertisment) {
        return new SuccessDataResult<>(this.jobAdvertismentDao.findAll(), "güncellendi");
    }

    @Override
    public DataResult<List<JobAdvertismentDetailsDto>> getAll() {
        List<JobAdvertisment> jobAdvertisements = jobAdvertismentDao.findAll();
        return new SuccessDataResult<List<JobAdvertismentDetailsDto>>(jobAdvertisementToDto(jobAdvertisements),"data listelendi");
    }


    @Override
    public DataResult<List<JobAdvertismentDetailsDto>> getJobAdvertiseWithEmployerDetails() {
        return new SuccessDataResult<List<JobAdvertismentDetailsDto>>(this.jobAdvertismentDao.getJobAdvertiseWithEmployerDetails());
    }


    @Override
    public DataResult<List<JobAdvertisment>> getAllByApplicationDeadline(Date date) {
        return new SuccessDataResult<>(this.jobAdvertismentDao.getAllByApplicationDeadLine(date), "son başvuru tarihine göre listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisment>> getAllByEmployer(int employerId) {
        return new SuccessDataResult<>(this.jobAdvertismentDao.findAllByEmployerIdAndActiveTrue(employerId));
    }

    @Override
    public DataResult<List<JobAdvertisment>> getAllByDateDesc() {
        return new SuccessDataResult<>(this.jobAdvertismentDao.findAllByActiveTrueOrderByApplicationDeadLineDesc());
    }

    @Override
    public DataResult<JobAdvertisment> updateActive(int id, boolean active) {
        JobAdvertisment tmpJobAdvertisment = this.jobAdvertismentDao.findById(id).orElse(null);
        tmpJobAdvertisment.setActive(active);
        this.jobAdvertismentDao.save(tmpJobAdvertisment);
        return new SuccessDataResult<JobAdvertisment>(tmpJobAdvertisment,"Güncellendi");
    }
    private List<JobAdvertismentDetailsDto> jobAdvertisementToDto(List<JobAdvertisment> jobAdvertisements) {
        return jobAdvertisements.stream().map(Advertisement -> modelMapper.map(Advertisement, JobAdvertismentDetailsDto.class)).collect(Collectors.toList());
    }



}
