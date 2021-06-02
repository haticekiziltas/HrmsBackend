package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.Talent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TalentDao extends JpaRepository<Talent, Integer> {
}
