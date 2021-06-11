package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTimeDao extends JpaRepository<WorkingTime, Integer> {
}
