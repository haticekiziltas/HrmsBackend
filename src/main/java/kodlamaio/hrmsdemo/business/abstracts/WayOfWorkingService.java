package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.entities.concretes.WayOfWorking;

import java.util.List;

public interface WayOfWorkingService {
    DataResult<List<WayOfWorking>> getAll();
    DataResult<WayOfWorking> getById(int id);
    DataResult<WayOfWorking> add(WayOfWorking wayOfWorking);
}
