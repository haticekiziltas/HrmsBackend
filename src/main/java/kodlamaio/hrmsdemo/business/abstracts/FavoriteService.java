package kodlamaio.hrmsdemo.business.abstracts;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.entities.concretes.Favorite;

import java.util.List;

public interface FavoriteService {
    DataResult<List<Favorite>> getAll();
    DataResult<Favorite> add(Favorite favorite);
    DataResult<List<Favorite>>  getAllByFavoriteById(int id);
}
