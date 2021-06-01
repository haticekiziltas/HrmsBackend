package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.EmployeeService;
import kodlamaio.hrmsdemo.business.abstracts.ValidationService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrmsdemo.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeManager implements EmployeeService {
    private EmployeeDao employeeDao;
    private ValidationService validationService;
    @Autowired
    public EmployeeManager(EmployeeDao employeeDao,ValidationService validationService) {
        this.employeeDao = employeeDao;
        this.validationService = validationService;
    }
    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>( this.employeeDao.findAll(),"Sistem Kullanıcıları Listelendi");
    }

    @Override
    public Result add(Employee employee) {
        this.employeeDao.save(employee);
        return new SuccessResult("Ekleme Başarılı");
    }
}
