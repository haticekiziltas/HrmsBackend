package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CvDao extends JpaRepository<Cv, Integer> {
    List<Cv> findAllByCandidate_Id(int id);
}

