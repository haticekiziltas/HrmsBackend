package kodlamaio.hrmsdemo.core.utilities.cloudinary;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    DataResult<?> save(MultipartFile file);
}
