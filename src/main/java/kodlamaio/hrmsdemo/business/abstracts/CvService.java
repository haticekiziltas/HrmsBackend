package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Cv;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CvService {

    DataResult<List<Cv>> getAll();
    Result add(Cv cv);
    Result saveImage(MultipartFile file, int resumeId);
}
