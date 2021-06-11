package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.WayOfWorkingService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.entities.concretes.WayOfWorking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wayofworkings")
@Api("Way Of Workings Controller")
@CrossOrigin
public class WayOfWorkingsController {
    private WayOfWorkingService wayOfWorkingService;
    @Autowired
    public WayOfWorkingsController(WayOfWorkingService wayOfWorkingService) {
        this.wayOfWorkingService = wayOfWorkingService;
    }

    @PostMapping("/add")
    @ApiOperation("Add Way Of Work")
    DataResult<WayOfWorking> add(@RequestBody WayOfWorking wayOfWorking) {
        return wayOfWorkingService.add(wayOfWorking);

    }

    @GetMapping("/getbyid")
    @ApiOperation("GetById WayOfWorking")
    DataResult<WayOfWorking> getById(@RequestParam("id") int id) {
        return wayOfWorkingService.getById(id);

    }

    @GetMapping("/getall")
    @ApiOperation("GetAll WayOfWorking")
    DataResult<List<WayOfWorking>> getAll() {
        return wayOfWorkingService.getAll();

    }
}
