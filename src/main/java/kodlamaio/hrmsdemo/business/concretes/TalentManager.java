package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.TalentService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.TalentDao;
import kodlamaio.hrmsdemo.entities.concretes.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentManager implements TalentService {
    private TalentDao talentDao;
    @Autowired
    public TalentManager(TalentDao talentDao){
        this.talentDao=talentDao;
    }
    @Override
    public DataResult<List<Talent>> getAll() {
        return new SuccessDataResult<List<Talent>>(this.talentDao.findAll(),"data listelendi");
    }

    @Override
    public Result add(Talent talent) {
        this.talentDao.save(talent);
        return new SuccessResult("ekleme başarılı");
    }
}
