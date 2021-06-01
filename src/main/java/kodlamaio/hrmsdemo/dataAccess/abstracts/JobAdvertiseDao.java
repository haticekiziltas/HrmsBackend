package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.Job;
import kodlamaio.hrmsdemo.entities.concretes.JobAdvertise;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertiseDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface JobAdvertiseDao  extends JpaRepository<JobAdvertise,Integer> {

    List<JobAdvertise> getAllByApplicationDeadLine(Date date);
    List<JobAdvertise> findAllByEmployerIdAndActiveTrue(int employerId);
    List<JobAdvertise> findAllByActiveTrueOrderByApplicationDeadLineDesc();


    @Query("Select new kodlamaio.hrmsdemo.entities.dtos.JobAdvertiseDetailsDto"
            + "(j.id,e.companyName,j.jobDescription,t.jobName,j.createdAt,c.cityName,j.applicationDeadLine) "
            + "From JobAdvertise j "
            +"inner join j.employer e "
            +"inner join j.job t "
            +"inner join j.city c " )
    List<JobAdvertiseDetailsDto> getJobAdvertiseWithEmployerDetails();

}
