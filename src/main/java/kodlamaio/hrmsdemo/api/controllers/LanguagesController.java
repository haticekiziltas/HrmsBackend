package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.LanguageService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/languages")
@Api("Language Api Documantation")
public class LanguagesController {
    private LanguageService languageService;
    @Autowired
    public  LanguagesController(LanguageService languageService){
        this.languageService= languageService;
    }
    @GetMapping("/getall")
    @ApiOperation("Get All Language")
    DataResult<List<Language>> getAll() {
        return this.languageService.getAll();
    }
    @PostMapping("/add")
    @ApiOperation("Add Language")
    public Result add(@Valid @RequestBody Language language) {

        return this.languageService.add(language);

    }
}
