package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.EducationService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.dtos.EducationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/education")
public class EducationsController {
    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/getall")
    @ApiOperation("Get All Education")
    DataResult<List<EducationDto>> getAll() {
        return this.educationService.getAll();

    }

    @PostMapping(value = "/add")
    @ApiOperation("Add Education")
    public Result add(@Valid @RequestBody EducationDto education) {

        return this.educationService.add(education);

    }

    @GetMapping("/getCvEducations")
    @ApiOperation("Get All Education")
    public DataResult<List<EducationDto>> findAllByCvIdOrderByEndedDate(int cvId) {

        return this.educationService.findAllByCvIdOrderByEndedDateDesc(cvId);
    }

}
