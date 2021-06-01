package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.JobAdvertisment;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertismentDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface JobAdvertismentDao extends JpaRepository<JobAdvertisment,Integer> {

    List<JobAdvertisment> getAllByApplicationDeadLine(Date date);
    List<JobAdvertisment> findAllByEmployerIdAndActiveTrue(int employerId);
    List<JobAdvertisment> findAllByActiveTrueOrderByApplicationDeadLineDesc();


    @Query("Select new kodlamaio.hrmsdemo.entities.dtos.JobAdvertismentDetailsDto"
            + "(j.id,e.companyName,j.jobDescription,t.jobName,j.createdAt,c.cityName,j.applicationDeadLine) "
            + "From JobAdvertisment j "
            +"inner join j.employer e "
            +"inner join j.job t "
            +"inner join j.city c " )
    List<JobAdvertismentDetailsDto> getJobAdvertiseWithEmployerDetails();

}
