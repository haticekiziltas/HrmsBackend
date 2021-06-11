package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.WorkingTimeService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.WorkingTimeDao;
import kodlamaio.hrmsdemo.entities.concretes.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTimeManager implements WorkingTimeService {
    private WorkingTimeDao workingTimeDao;

    @Autowired
    public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
        this.workingTimeDao = workingTimeDao;
    }

    @Override
    public DataResult<List<WorkingTime>> getAll() {
        return new SuccessDataResult<List<WorkingTime>>(workingTimeDao.findAll(),"Çalışma Zamanları Listelendi");
    }

    @Override
    public DataResult<WorkingTime> getById(int id) {
        return new SuccessDataResult<WorkingTime>(workingTimeDao.getOne(id));
    }

    @Override
    public DataResult<WorkingTime> add(WorkingTime workingTime) {
        return new SuccessDataResult<WorkingTime>(workingTimeDao.save(workingTime),"Ekleme Başarılı");
    }
}
