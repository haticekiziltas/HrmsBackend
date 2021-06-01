package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Education;

import java.util.List;

public interface EducationService {
    DataResult<List<Education>> getAll();
    Result add(Education education);
}
