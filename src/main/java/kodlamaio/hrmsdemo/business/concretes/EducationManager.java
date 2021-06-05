package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.EducationService;
import kodlamaio.hrmsdemo.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.EducationDao;
import kodlamaio.hrmsdemo.entities.concretes.Education;
import kodlamaio.hrmsdemo.entities.dtos.EducationDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;
    private ModelMapper modelMapper;
    private DtoConverterService dtoConverterService;

    @Autowired
    public EducationManager(EducationDao educationDao, ModelMapper modelMapper, DtoConverterService dtoConverterService) {
        this.educationDao = educationDao;
        this.modelMapper=modelMapper;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<EducationDto>> getAll() {
        return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educationDao.findAll(),EducationDto.class),"Data Listelendi");
    }

    @Override
    public DataResult<EducationDto> add(EducationDto educationDto) {
        this.educationDao.save((Education) dtoConverterService.dtoClassConverter(educationDto, Education.class));
        return new SuccessDataResult<EducationDto>(educationDto, "Okul Eklendi");


    }

    @Override
    public DataResult<List<EducationDto>> findAllByCvIdOrderByEndedDateDesc(int cvId) {
        List<Education> educations = educationDao.findAllByCvIdOrderByEndedDateDesc(cvId);
        return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educations,EducationDto.class));
    }
    //private List<EducationDto> educationToDto(List<Education> educations) {
       // return educations.stream().map(Education -> modelMapper.map(Education, EducationDto.class)).collect(Collectors.toList());
   // }
}
