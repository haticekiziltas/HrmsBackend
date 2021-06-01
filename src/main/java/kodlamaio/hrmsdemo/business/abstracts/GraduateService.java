package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Graduate;

import java.util.List;

public interface GraduateService {
    DataResult<List<Graduate>> getAll();
    Result add(Graduate graduate);
}
