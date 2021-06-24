package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.FavoriteService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.FavoriteDao;
import kodlamaio.hrmsdemo.entities.concretes.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteManager implements FavoriteService {

    private FavoriteDao favoriteDao;
    @Autowired
    public FavoriteManager(FavoriteDao favoriteDao) {
        this.favoriteDao = favoriteDao;
    }

    @Override
    public DataResult<List<Favorite>> getAll() {
        return new SuccessDataResult<List<Favorite>>(this.favoriteDao.findAll(), "Data Listelendi");
    }


    @Override
    public DataResult<Favorite> add(Favorite favorite) {
        return new SuccessDataResult<Favorite>(this.favoriteDao.save(favorite), "favorilere eklendi");
    }

    @Override
    public DataResult<List<Favorite>> getAllByFavoriteById(int id) {
        return new SuccessDataResult<List<Favorite>>(favoriteDao.findAllByCandidate_Id(id));
    }
}
