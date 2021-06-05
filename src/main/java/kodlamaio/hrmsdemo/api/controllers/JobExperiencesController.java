package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.JobExperienceService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.JobExperience;
import kodlamaio.hrmsdemo.entities.dtos.JobExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/jobexperiences")
@Api(value = "jop experience api documentation")
public class JobExperiencesController {
    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("/getall")
    @ApiOperation("Get All JobExperience")
    DataResult<List<JobExperience>> getAll() {
        return this.jobExperienceService.getAll();

    }

    @PostMapping("/add")
    @ApiOperation("Add JobExperience")
    public Result add(@Valid @RequestBody JobExperienceDto jobExperience) {

        return this.jobExperienceService.add(jobExperience);

    }
    @GetMapping("/getCvJobExperiences")
    @ApiOperation("Get All Education")
    public DataResult<List<JobExperienceDto>> findAllByCvIdOrderByEndedDate(int cvId) {

        return this.jobExperienceService.findAllByCvIdOrderByEndedDate(cvId);
    }

}
