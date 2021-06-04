package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.JobExperience;
import kodlamaio.hrmsdemo.entities.dtos.JobExperienceDto;

import java.util.List;

public interface JobExperienceService {
    DataResult<List<JobExperience>> getAll();
    DataResult<JobExperienceDto> add(JobExperienceDto jobExperienceDto);
    DataResult<List<JobExperienceDto>> findAllByCvIdOrderByEndedDate(int id);
}
