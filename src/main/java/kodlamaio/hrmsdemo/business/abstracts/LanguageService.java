package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Language;
import kodlamaio.hrmsdemo.entities.dtos.LanguageDto;

import java.util.List;

public interface LanguageService {
    DataResult<List<Language>> getAll();

    DataResult<LanguageDto> add(LanguageDto languageDto);

}
