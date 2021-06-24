package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.CvService;
import kodlamaio.hrmsdemo.core.utilities.cloudinary.CloudinaryService;
import kodlamaio.hrmsdemo.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrmsdemo.core.utilities.helpers.CvHelperService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.CvDao;
import kodlamaio.hrmsdemo.entities.concretes.Cv;
import kodlamaio.hrmsdemo.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsdemo.entities.dtos.CvDto;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertisementDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CvManager implements CvService {
    private CvDao cvDao;
    private CloudinaryService cloudinaryService;
    private CvHelperService cvHelperService;
    private DtoConverterService dtoConverterService;
    @Autowired
    public CvManager(CvDao cvDao, CloudinaryService cloudinaryService, CvHelperService cvHelperService, DtoConverterService dtoConverterService) {
        this.cvDao = cvDao;
        this.cloudinaryService = cloudinaryService;
        this.cvHelperService= cvHelperService;
        this.dtoConverterService =dtoConverterService;

    }

    @Override
    public DataResult<List<CvDto>> getAll() {
        return new SuccessDataResult<List<CvDto>>(dtoConverterService.dtoConverter(cvDao.findAll(),CvDto.class), "Data Listelendi");
    }

    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        this.cvHelperService.setAllCvId(cv.getEducations(), cv.getLanguages(), cv.getTalents(), cv.getJobExperiences(), cv);
        return new SuccessResult("ekleme başarılı");
    }

    @Override
    public DataResult updateCv(Cv cv) {
        this.cvHelperService.setAllCvId(cv.getEducations(), cv.getLanguages(), cv.getTalents(),cv.getJobExperiences(), cv);
        this.cvDao.save(cv);
        return  new SuccessDataResult<Cv>(cv,"güncellendi");
    }

    @Override
    public Result deleteCv(int id) {
        cvDao.deleteById(id);
        return new SuccessResult("cv silindi");
    }

    @Override
    public DataResult<List<Cv>> getAllCandidateId(int id) {
        return  new SuccessDataResult<List<Cv>>(cvDao.findAllByCandidateId(id));
    }

    @Override
    public Result saveImage(MultipartFile file, int cvId) {
        Map<String, String> uploader = (Map<String, String>)  cloudinaryService.save(file).getData();
        String imageUrl= uploader.get("url");
        Cv cva = cvDao.findById(cvId).orElse(null);
        assert cva != null;
        Cv Cv = cvDao.getOne(cvId);
        Cv.setPhoto(imageUrl);
        cvDao.save(Cv);
        return new SuccessResult("Kayıt Başarılı");
    }





}
