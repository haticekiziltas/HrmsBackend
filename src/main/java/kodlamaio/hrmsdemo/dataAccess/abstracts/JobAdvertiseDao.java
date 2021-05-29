package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.Job;
import kodlamaio.hrmsdemo.entities.concretes.JobAdvertise;
import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Date;
import java.util.List;

public interface JobAdvertiseDao  extends JpaRepository<JobAdvertise,Integer> {

    List<JobAdvertise> getAllByApplicationDeadLine(Date date);
    List<JobAdvertise> findAllByEmployerIdAndActiveTrue(int employerId);
    List<JobAdvertise> findAllByActiveTrueOrderByApplicationDeadLineDesc();

//    @Query("From JobAdvertise where isJobAdvertiseActive = true")
//    List<JobAdvertise> getJobAdvertiseActive();
//
//    @Query("From JobAdvertise where isJobAdvertiseActive = true Order By createdDate Desc ")
//    List<JobAdvertise> getJobAdvertiseActiveOrderBy();
//
//    @Query("From JobAdvertise where isJobAdvertiseActive = true and employer.employerId =:id")
//    List<JobAdvertise> getEmployerActiveAdvertise(int id);

}
