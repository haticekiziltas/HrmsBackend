package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.Education;
import kodlamaio.hrmsdemo.entities.dtos.EducationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education, Integer> {

    List<Education> findAllByCvIdOrderByEndedDateDesc(int id);
}


