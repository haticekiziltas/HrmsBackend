package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.JobAdvertise;
import org.springframework.data.jpa.repository.JpaRepository;


import java.sql.Date;

import java.util.List;

public interface JobAdvertiseDao  extends JpaRepository<JobAdvertise,Integer> {


    List<JobAdvertise> getAllByApplicationDeadLine(Date date);
    List<JobAdvertise> findAllByEmployerIdAndActiveTrue(int employerId);

}
