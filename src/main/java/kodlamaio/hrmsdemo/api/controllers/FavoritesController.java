package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.FavoriteService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@Api("Favorite Api Documantation")
public class FavoritesController {

    private FavoriteService favoriteService;

    @Autowired
    public FavoritesController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("/getall")
    @ApiOperation("Get All Favroite")
    DataResult<List<Favorite>> getAll() {
        return this.favoriteService.getAll();
    }
    @PostMapping("/add")
    @ApiOperation("Add Favroite")
    public Result add(@Valid @RequestBody Favorite favorite){
        return this.favoriteService.add(favorite);
    }
    @GetMapping("/getAllByFavoriteById")
    @ApiOperation("Get All Favroite By Id")
    DataResult<List<Favorite>> getAllByFavoriteById(@RequestParam("id") int id) {
        return this.favoriteService.getAllByFavoriteById(id);
    }
}
