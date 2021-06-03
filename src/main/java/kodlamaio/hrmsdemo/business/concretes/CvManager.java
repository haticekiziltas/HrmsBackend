package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.CvService;
import kodlamaio.hrmsdemo.core.utilities.cloudinary.CloudinaryService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.CvDao;
import kodlamaio.hrmsdemo.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class CvManager implements CvService {
    private CvDao cvDao;
    private CloudinaryService cloudinaryService;
    @Autowired
    public CvManager(CvDao cvDao, CloudinaryService cloudinaryService) {
        this.cvDao = cvDao;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "Data Listelendi");
    }

    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult("ekleme başarılı");
    }

    @Override
    public Result saveImage(MultipartFile file, int resumeId) {
        Map<String, String> uploader = (Map<String, String>)  cloudinaryService.save(file).getData();
        String imageUrl= uploader.get("url");
        Cv Cv = cvDao.getOne(resumeId);
        Cv.setPhoto(imageUrl);
        cvDao.save(Cv);
        return new SuccessResult("Kayıt Başarılı");
    }
}
