package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteDao extends JpaRepository <Favorite, Integer> {
    List<Favorite> findAllByCandidate_Id(int id);
}
