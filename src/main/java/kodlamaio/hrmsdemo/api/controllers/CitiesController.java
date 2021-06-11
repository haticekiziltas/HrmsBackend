package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.CityService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cities")
@CrossOrigin
public class CitiesController {
    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    @ApiOperation("Add City")
    DataResult<City> add(@RequestBody City city) {
        return cityService.add(city);

    }

    @GetMapping("/getbyid")
    @ApiOperation("GetById City")
    DataResult<City> getById(@RequestParam("id") int id) {
        return cityService.getById(id);

    }

    @GetMapping("/getall")
    @ApiOperation("GetAll City")
    DataResult<List<City>> getAll() {
        return cityService.getAll();

    }
}
