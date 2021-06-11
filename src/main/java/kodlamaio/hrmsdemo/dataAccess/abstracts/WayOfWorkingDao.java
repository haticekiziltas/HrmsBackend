package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.WayOfWorking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WayOfWorkingDao extends JpaRepository<WayOfWorking, Integer> {
}
