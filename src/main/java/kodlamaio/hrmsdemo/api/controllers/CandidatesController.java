package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.CandidateService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@Api("Candidate Methods")
public class CandidatesController {


    @Autowired
    private CandidateService candidateService;

    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    @ApiOperation("GetAll Method")
    public DataResult<List<Candidate>> getAll() {
        return this.candidateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid  Candidate candidate) throws Exception {
        return this.candidateService.add(candidate);

    }
}
