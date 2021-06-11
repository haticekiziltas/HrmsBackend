package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.entities.concretes.WorkingTime;

import java.util.List;

public interface WorkingTimeService {
    DataResult<List<WorkingTime>> getAll();
    DataResult<WorkingTime> getById(int id);
    DataResult<WorkingTime> add(WorkingTime workingTime);

}
