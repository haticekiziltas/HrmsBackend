package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.TalentService;
import kodlamaio.hrmsdemo.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.TalentDao;
import kodlamaio.hrmsdemo.entities.concretes.Talent;
import kodlamaio.hrmsdemo.entities.dtos.TalentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentManager implements TalentService {
    private TalentDao talentDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public TalentManager(TalentDao talentDao,DtoConverterService dtoConverterService) {
        this.talentDao = talentDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<Talent>> getAll() {
        return new SuccessDataResult<List<Talent>>(this.talentDao.findAll(), "Data Listelendi");
    }

    @Override
    public DataResult<TalentDto> add(TalentDto talentDto) {
        this.talentDao.save((Talent) dtoConverterService.dtoClassConverter(talentDto, Talent.class));
        return new SuccessDataResult<TalentDto>(talentDto, "Yetenek Eklendi");
    }
}
