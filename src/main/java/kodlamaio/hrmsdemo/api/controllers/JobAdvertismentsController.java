package kodlamaio.hrmsdemo.api.controllers;

import kodlamaio.hrmsdemo.business.abstracts.JobAdvertismentService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.JobAdvertisment;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertismentDetailsDto;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertismentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisment")
public class JobAdvertismentsController {
    private JobAdvertismentService jobAdvertismentService;

    @Autowired
    public JobAdvertismentsController(JobAdvertismentService jobAdvertismentService) {
        super();
        this.jobAdvertismentService = jobAdvertismentService;
    }

   @GetMapping("/getall")
   public DataResult<List<JobAdvertismentDetailsDto>>  getAll() {
        return this.jobAdvertismentService.getAll();
   }
    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertismentRequestDto jobAdvertisment) {
        return this.jobAdvertismentService.add(jobAdvertisment);
    }

    @GetMapping("/getJobAdvertiseWithEmployerDetails")
    public DataResult<List<JobAdvertismentDetailsDto>> getJobAdvertiseWithEmployerDetails() {
        return this.jobAdvertismentService.getJobAdvertiseWithEmployerDetails();
    }

    @GetMapping("/getallbyapplicationdeadline")
    public DataResult<List<JobAdvertisment>> getAllByApplicationDeadline
            (@RequestParam Date date) {
        return this.jobAdvertismentService.getAllByApplicationDeadline(date);
    }

    @GetMapping("/getallbyemployer")
    public DataResult<List<JobAdvertisment>> getAllByEmployer(@RequestParam int employerId) {
        return this.jobAdvertismentService.getAllByEmployer(employerId);
    }
    @GetMapping("/getallbydateDesc")
    public DataResult<List<JobAdvertisment>> getAllByDateDesc() {
        return this.jobAdvertismentService.getAllByDateDesc();
    }

    @PutMapping("/updateActive")
    public DataResult<JobAdvertisment> updateActive(@RequestParam int id , @RequestParam boolean active){
        return this.jobAdvertismentService.updateActive(id,active);
    }
}