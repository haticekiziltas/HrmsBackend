package kodlamaio.hrmsdemo.api.controllers;

import kodlamaio.hrmsdemo.business.abstracts.JobAdvertiseService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.JobAdvertise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisment")
public class JobAdvertiseController {
    private JobAdvertiseService jobAdvertiseService;

    @Autowired
    public JobAdvertiseController(JobAdvertiseService jobAdvertiseService) {
        this.jobAdvertiseService = jobAdvertiseService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertise jobAdvertise) {
        return this.jobAdvertiseService.add(jobAdvertise);
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertise>> getAll() {
        return this.jobAdvertiseService.getAll();
    }

    @GetMapping("/getallbyapplicationdeadline")
    public DataResult<List<JobAdvertise>> getAllByApplicationDeadline
            (@RequestParam Date date) {
        return this.jobAdvertiseService.getAllByApplicationDeadline(date);
    }

    @GetMapping("/getallbyemployer")
    public DataResult<List<JobAdvertise>> getAllByEmployer(@RequestParam int employerId) {
        return this.jobAdvertiseService.getAllByEmployer(employerId);
    }

    @PutMapping("/updateActive")
    public DataResult<JobAdvertise> updateActive(@RequestParam int id ,@RequestParam boolean active){
        return this.jobAdvertiseService.updateActive(id,active);
    }
}