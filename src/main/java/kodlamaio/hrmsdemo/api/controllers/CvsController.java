package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.CvService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Cv;
import kodlamaio.hrmsdemo.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cvs")
@CrossOrigin
public class CvsController {

    private CvService cvService;

    @Autowired
    public CvsController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/getall")
    @ApiOperation("Get All Graduate")
    DataResult<List<CvDto>> getAll() {
        return this.cvService.getAll();

    }
    @GetMapping("/getallCandidateId")
    @ApiOperation("Get All Cv")
    DataResult<List<Cv>> getAllCandidateId(@RequestParam int id) {
        return this.cvService.getAllCandidateId(id);

    }

    @PostMapping("/add")
    @ApiOperation("Add Graduate")
    public Result add(@Valid @RequestBody Cv cv) {

        return this.cvService.add(cv);
    }

    @PutMapping("/uploadImage")
    public Result saveImage(@RequestBody MultipartFile file, @RequestParam int cvId) {
        return this.cvService.saveImage(file, cvId);

    }
}
