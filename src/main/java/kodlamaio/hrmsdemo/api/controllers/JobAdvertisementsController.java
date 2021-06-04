package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.JobAdvertisementService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertisementDto;
import kodlamaio.hrmsdemo.entities.dtos.JobAdvertisementRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisment")
public class JobAdvertisementsController {
    @Autowired
    private JobAdvertisementService jobAdvertisementService;

    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getallAd")
    @ApiOperation(value = "Get Byid Method")
    DataResult<List<JobAdvertisementDto>> getAllAd() {
        return this.jobAdvertisementService.getAllAd();
    }

        @PostMapping("/addAd")
        @ApiOperation(value = "Add AD Method")
        ResponseEntity<?> add (@Valid @RequestBody JobAdvertisementRequestDto jobAdvertisement){
            return ResponseEntity.ok(this.jobAdvertisementService.addAd(jobAdvertisement));

        }
        @GetMapping("/getActive")
        @ApiOperation(value = "get Actv Method")
        DataResult<List<JobAdvertisementDto>> getActive () {
            return this.jobAdvertisementService.getActive();

        }
        @GetMapping("/getActiveandEmp")
        @ApiOperation(value = "get emp Method")
        DataResult<List<JobAdvertisementDto>> getEmpId ( @RequestParam int id){
            return this.jobAdvertisementService.getEmpId(id);

        }

        @GetMapping("/getActiveAndDate")
        @ApiOperation(value = "get emp Method")
        DataResult<List<JobAdvertisementDto>> getAdDate () {
            return this.jobAdvertisementService.getAdDate();

        }
        @PutMapping("/updateActive")
        @ApiOperation(value = "get emp Method")
        DataResult<JobAdvertisement> updateActive ( @RequestParam int id, @RequestParam boolean active){
            return this.jobAdvertisementService.updateActive(id, active);

        }

        @GetMapping("/getAdCustomDate")
        @ApiOperation(value = "get emp Method")
        DataResult<List<JobAdvertisementDto>> getAdCustomDate (@RequestParam Date date){
            return this.jobAdvertisementService.getAdCustomDate(date);

        }

    }
