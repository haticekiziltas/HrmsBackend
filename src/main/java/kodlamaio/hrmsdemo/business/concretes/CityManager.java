package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.CityService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.CityDao;
import kodlamaio.hrmsdemo.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager  implements CityService {

    public CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }
    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(cityDao.findAll(),"Şehirler Getirildi");
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(cityDao.getOne(id));
    }

    @Override
    public DataResult<City> add(City city) {
        return new SuccessDataResult<City>(cityDao.save(city),"Şehir Kaydı Başarılı");
    }
}
