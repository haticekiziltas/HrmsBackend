package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.WorkingTimeService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.entities.concretes.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/workingstime")
@CrossOrigin
public class WorkingsTimeController {
    private WorkingTimeService workingTimeService;
    @Autowired
    public WorkingsTimeController(WorkingTimeService workingTimeService) {
        this.workingTimeService = workingTimeService;
    }

    @PostMapping("/add")
    @ApiOperation("Add Working Time")
    DataResult<WorkingTime> add(@RequestBody WorkingTime workingTime) {
        return workingTimeService.add(workingTime);

    }

    @GetMapping("/getbyid")
    @ApiOperation("GetById Working Time")
    DataResult<WorkingTime> getById(@RequestParam("id") int id) {
        return workingTimeService.getById(id);

    }

    @GetMapping("/getall")
    @ApiOperation("GetAll WayOfWorking")
    DataResult<List<WorkingTime>> getAll() {
        return workingTimeService.getAll();

    }
}
