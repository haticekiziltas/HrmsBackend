package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.EmployerService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Employer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employers")
@Api("Employers")
public class EmployersController {
    private EmployerService employerService;

    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    @ApiOperation("Get All Employers")
    DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();

    }

    @PostMapping("/add")
    @ApiOperation("Add Employer")
    public Result add(@RequestBody Employer employer) {

        return this.employerService.add(employer);

    }


}
