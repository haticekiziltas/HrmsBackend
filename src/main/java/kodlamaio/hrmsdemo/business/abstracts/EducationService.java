package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.entities.dtos.EducationDto;

import java.util.List;

public interface EducationService {
    DataResult<List<EducationDto>> getAll();
    DataResult<EducationDto> add(EducationDto education);
    DataResult<List<EducationDto>> findAllByCvIdOrderByEndedDateDesc(int cvId);
}
