package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;


import java.sql.Date;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    List<JobAdvertisement> findAllByActiveTrue();
    List<JobAdvertisement> findAllByEmployerIdAndActiveTrue(int id);
    List<JobAdvertisement> findAllByActiveTrueOrderByEndDateDesc();
    List<JobAdvertisement> findAllByCreatedAt(Date date);

    //@Query("Select new kodlamaio.hrmsdemo.entities.dtos.JobAdvertisementDto"
          //  + "(j.id,e.companyName,j.jobDescription,t.jobName,j.createdAt,c.cityName,j.applicationDeadLine) "
           // + "From JobAdvertisement j "
           // +"inner join j.employer e "
            //+"inner join j.job t "
            //+"inner join j.city c " )
   // List<JobAdvertisementDto> getJobAdvertisementWithEmployerDetails();

}

