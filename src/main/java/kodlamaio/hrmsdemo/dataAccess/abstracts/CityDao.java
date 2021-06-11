package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {
}
