package kodlamaio.hrmsdemo.business.concretes;

import kodlamaio.hrmsdemo.business.abstracts.EmployeeService;
import kodlamaio.hrmsdemo.business.abstracts.ValidationService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsdemo.core.utilities.results.SuccessResult;
import kodlamaio.hrmsdemo.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrmsdemo.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsdemo.entities.concretes.Employee;
import kodlamaio.hrmsdemo.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {
    private EmployeeDao employeeDao;
    private EmployerDao employerDao;
    private ValidationService validationService;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao,ValidationService validationService, EmployerDao employerDao) {
        this.employeeDao = employeeDao;
        this.validationService = validationService;
        this.employerDao= employerDao;
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

    @Override
    public Result verifyEmployer(int employerId, boolean verify) {
        Employer emp = new Employer();
        emp = employerDao.getOne(employerId);
        emp.setVerify(verify);
        employerDao.save(emp);
        if(verify){
            return new SuccessResult("Kullanıcı Aktif Edildi"+emp.getCompanyName());
        }
        return new SuccessResult("Kullanıcı Pasif Edildi"+emp.getCompanyName());
    }

    @Override
    public Result updateInfo(Employee employee) {
        this.employeeDao.save(employee);
        return new SuccessResult("güncellendi");
    }

}

