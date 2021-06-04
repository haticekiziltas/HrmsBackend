package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.JobExperienceService;
import kodlamaio.hrmsdemo.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrmsdemo.entities.concretes.JobExperience;
import kodlamaio.hrmsdemo.entities.dtos.JobExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    private JobExperienceDao jobExperienceDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao, DtoConverterService dtoConverterService) {
        this.jobExperienceDao = jobExperienceDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(), "Data Listelendi");
    }

    @Override
    public DataResult<JobExperienceDto> add(JobExperienceDto jobExperienceDto) {
        this.jobExperienceDao.save((JobExperience) dtoConverterService.dtoClassConverter(jobExperienceDto, JobExperience.class));
        return new SuccessDataResult<JobExperienceDto>(jobExperienceDto, "İş Deneyimi Eklendi");
    }

    @Override
    public DataResult<List<JobExperienceDto>> findAllByCvIdOrderByEndedDate(int id) {
        List<JobExperience> jobExperiences = jobExperienceDao.findAllByCvIdOrderByEndedDateDesc(id);
        return new SuccessDataResult<List<JobExperienceDto>>(dtoConverterService.dtoConverter(jobExperiences, JobExperienceDto.class));
    }
}
