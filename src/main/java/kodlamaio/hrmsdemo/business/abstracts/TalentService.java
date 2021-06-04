package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Talent;
import kodlamaio.hrmsdemo.entities.dtos.TalentDto;

import java.util.List;

public interface TalentService {
    DataResult<List<Talent>> getAll();

    DataResult<TalentDto> add(TalentDto talentDto);
}
