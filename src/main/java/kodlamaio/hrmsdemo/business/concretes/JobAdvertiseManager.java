package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.JobAdvertiseService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsdemo.dataAccess.abstracts.JobAdvertiseDao;
import kodlamaio.hrmsdemo.entities.concretes.JobAdvertise;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertiseDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;

@Service
public class JobAdvertiseManager implements JobAdvertiseService {
    private JobAdvertiseDao jobAdvertiseDao;



    @Autowired
    public JobAdvertiseManager(JobAdvertiseDao jobAdvertiseDao) {
        super();
        this.jobAdvertiseDao = jobAdvertiseDao;


    }
    @Override
    public Result add(JobAdvertise jobAdvertise) {
        return new SuccessDataResult<JobAdvertise>(this.jobAdvertiseDao.save(jobAdvertise)," ilan oluşturuldu");
    }

    @Override
    public Result update(JobAdvertise jobAdvertise) {
        return new SuccessDataResult<>(this.jobAdvertiseDao.findAll(), "güncellendi");
    }

    @Override
    public DataResult<List<JobAdvertise>> getAll() {
        return new SuccessDataResult<List<JobAdvertise>>(jobAdvertiseDao.findAll(),"data listelendi");
    }


    @Override
    public DataResult<List<JobAdvertiseDetailsDto>> getJobAdvertiseWithEmployerDetails() {
        return new SuccessDataResult<List<JobAdvertiseDetailsDto>>(this.jobAdvertiseDao.getJobAdvertiseWithEmployerDetails());
    }


    @Override
    public DataResult<List<JobAdvertise>> getAllByApplicationDeadline(Date date) {
        return new SuccessDataResult<>(this.jobAdvertiseDao.getAllByApplicationDeadLine(date), "son başvuru tarihine göre listelendi");
    }

    @Override
    public DataResult<List<JobAdvertise>> getAllByEmployer(int employerId) {
        return new SuccessDataResult<>(this.jobAdvertiseDao.findAllByEmployerIdAndActiveTrue(employerId));
    }

    @Override
    public DataResult<List<JobAdvertise>> getAllByDateDesc() {
        return new SuccessDataResult<>(this.jobAdvertiseDao.findAllByActiveTrueOrderByApplicationDeadLineDesc());
    }

    @Override
    public DataResult<JobAdvertise> updateActive(int id, boolean active) {
        JobAdvertise tmpJobAdvertise = this.jobAdvertiseDao.findById(id).orElse(null);
        tmpJobAdvertise.setActive(active);
        this.jobAdvertiseDao.save(tmpJobAdvertise);
        return new SuccessDataResult<JobAdvertise>(tmpJobAdvertise,"Güncellendi");
    }



}
