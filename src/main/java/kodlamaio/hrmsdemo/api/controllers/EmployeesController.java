package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.EmployeeService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.entities.concretes.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Api("All Employees Methods")
public class EmployeesController {
    private EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "GetAll Method")
    public DataResult<List<Employee>> getAll() {

        return this.employeeService.getAll();


    }

    @PostMapping("/add")
    @ApiOperation(value = "ADD Method")
    public ResponseEntity<?> add(@RequestBody @Valid Employee employee) {

        return ResponseEntity.ok(this.employeeService.add(employee));


    }
}
