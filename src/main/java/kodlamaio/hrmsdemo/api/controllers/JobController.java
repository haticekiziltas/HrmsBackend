package kodlamaio.hrmsdemo.api.controllers;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.JobService;
import kodlamaio.hrmsdemo.entities.concretes.Job;

@RestController
@RequestMapping("/api")
@Api(value = "Job Api documentation")
public class JobController {
    private JobService jobService;


    public JobController(JobService jobService) {
        super();
        this.jobService = jobService;
    }

    @GetMapping("/getall")
    @ApiOperation(value = "Get All Method")
    DataResult<List<Job>> getAll() {
        return jobService.getAll();

    }

    @GetMapping("/getbyid")
    @ApiOperation(value = "Get Byid Method")
    DataResult<Optional<Job>> getById(int id) {
        return this.jobService.getById(id);

    }
    @PostMapping("/add")
    @ApiOperation(value = "Add Job Method")
    Result add(@RequestBody Job job) {
        return this.jobService.add(job);

    }

}
