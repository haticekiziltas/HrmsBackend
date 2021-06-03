package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.CvService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {
    private CvService cvService;

    @Autowired
    public CvsController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/getall")
    @ApiOperation("Get All Graduate")
    DataResult<List<Cv>> getAll() {
        return this.cvService.getAll();

    }

    @PostMapping("/add")
    @ApiOperation("Add Graduate")
    public Result add(@Valid @RequestBody Cv cv) {

        return this.cvService.add(cv);

    }


    @PutMapping("/uploadImage")
    public Result saveImage(@RequestBody MultipartFile file, @RequestParam int resumeId) {
        return this.cvService.saveImage(file, resumeId);

    }
}
