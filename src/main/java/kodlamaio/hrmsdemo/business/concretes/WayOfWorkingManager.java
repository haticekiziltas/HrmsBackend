package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.WayOfWorkingService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.WayOfWorkingDao;
import kodlamaio.hrmsdemo.entities.concretes.WayOfWorking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WayOfWorkingManager implements WayOfWorkingService {


    private WayOfWorkingDao wayOfWorkingDao;

    @Autowired
    public WayOfWorkingManager(WayOfWorkingDao wayOfWorkingDao) {
        this.wayOfWorkingDao = wayOfWorkingDao;
    }
    @Override
    public DataResult<List<WayOfWorking>> getAll() {
        return new SuccessDataResult<List<WayOfWorking>>(wayOfWorkingDao.findAll(),"Çalışma Türleri Listelendi");
    }

    @Override
    public DataResult<WayOfWorking> getById(int id) {
        return new SuccessDataResult<WayOfWorking>(wayOfWorkingDao.getOne(id),"Getirildi");
    }

    @Override
    public DataResult<WayOfWorking> add(WayOfWorking wayOfWorking) {
        this.wayOfWorkingDao.save(wayOfWorking);
        return new SuccessDataResult<WayOfWorking>("Ekleme Başarılı");
    }
}
