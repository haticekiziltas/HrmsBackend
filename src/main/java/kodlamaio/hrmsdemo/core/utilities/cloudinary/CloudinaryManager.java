package kodlamaio.hrmsdemo.core.utilities.cloudinary;

import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.ErrorDataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.Cloudinary;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryManager implements CloudinaryService{
    private Cloudinary cloudinary;

    @Autowired
    public CloudinaryManager(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public DataResult<?> save(MultipartFile file) {
        try{
            Map cloudinaryUploader = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(cloudinaryUploader);
        } catch (IOException e){

        }
        return new ErrorDataResult<Map>();
    }

}

