package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.JobAdvertisementService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrmsdemo.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertisementDto;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertisementRequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;
    private ModelMapper modelMapper;



    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, ModelMapper modelMapper) {
        super();
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.modelMapper = modelMapper;



    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getAllAd() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAll();
        return  new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementToDto(jobAdvertisements), "Başarıyla Listelendi");
    }

    @Override
    public DataResult<JobAdvertisementRequestDto> addAd(JobAdvertisementRequestDto jobAdvertisement) {
        JobAdvertisement jobAdvertisements = modelMapper.map(jobAdvertisement,JobAdvertisement.class);
        jobAdvertisementDao.save(jobAdvertisements);

        return new SuccessDataResult<JobAdvertisementRequestDto>(jobAdvertisement, "İlan Eklendi");
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getActive() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAllByActiveTrue();
        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementToDto(jobAdvertisements), "Tüm Aktif İlanlar Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> findAllByActiveFalseOrderByCreatedAtDesc() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAllByActiveFalseOrderByCreatedAtDesc();
        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementToDto(jobAdvertisements), "Tüm pasif ilanlar getirildi");
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getEmpId(int id) {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAllByEmployerIdAndActiveTrue(id);
        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementToDto(jobAdvertisements), "Firmaya ait İş ilanları Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getAdDate() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAllByActiveTrueOrderByEndDateDesc();
        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementToDto(jobAdvertisements), "Aktif İlanlar Tarihe Göre Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getAdCustomDate(Date date) {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAllByCreatedAt(date);
        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementToDto(jobAdvertisements), "İstenilen Tarihe Göre Sıralandı");
    }

    @Override
    public DataResult<JobAdvertisement> updateActive(int id, boolean active) {
        JobAdvertisement tempAdvertisement = jobAdvertisementDao.findById(id).orElse(null);
        tempAdvertisement.setActive(active);
        this.jobAdvertisementDao.save(tempAdvertisement);
        return new SuccessDataResult<JobAdvertisement>(tempAdvertisement, "Güncellendi");
    }
    private List<JobAdvertisementDto> jobAdvertisementToDto(List<JobAdvertisement> jobAdvertisements) {
        return jobAdvertisements.stream().map(Advertisement -> modelMapper.map(Advertisement, JobAdvertisementDto.class)).collect(Collectors.toList());
    }
}
