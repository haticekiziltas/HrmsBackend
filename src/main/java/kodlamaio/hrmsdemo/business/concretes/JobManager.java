package kodlamaio.hrmsdemo.business.concretes;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrmsdemo.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsdemo.business.abstracts.JobService;
import kodlamaio.hrmsdemo.dataAccess.abstracts.JobDao;
import kodlamaio.hrmsdemo.entities.concretes.Job;
import org.springframework.web.bind.annotation.RequestBody;

@Service

public class JobManager implements JobService {
    private JobDao jobDao;

    @Autowired
    public JobManager(JobDao jobDao) {
        super();
        this.jobDao = jobDao;
    }

    @Override
    public DataResult<List<Job>> getAll() {
        // TODO Auto-generated method stub
        return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "Pozisyonlar Listelendi");

    }

    @Override
    public DataResult<Optional<Job>> getById(int id) {
        // TODO Auto-generated method stub
        return new SuccessDataResult<Optional<Job>>(this.jobDao.findById(id));
    }

    @Override
    public Result add(@RequestBody Job job) {
        if(jobDao.existsByJobName(job.getJobName())){

            return new ErrorResult("Pozisyon ismi var");
        }else{
            jobDao.save(job);
            return new SuccessResult("Başarıyla İş Eklendi");
        }
    }

}
