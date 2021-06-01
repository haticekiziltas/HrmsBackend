package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.GraduateService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.GraduateDao;
import kodlamaio.hrmsdemo.entities.concretes.Graduate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraduateManager implements GraduateService {
    private GraduateDao graduateDao;

    @Autowired
    public GraduateManager(GraduateDao graduateDao) {
        this.graduateDao = graduateDao;
    }

    @Override
    public DataResult<List<Graduate>> getAll() {
        return new SuccessDataResult<List<Graduate>>(this.graduateDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result add(Graduate graduate) {
        this.graduateDao.save(graduate);
        return new SuccessResult("Ekleme Başarılı");
    }
}
