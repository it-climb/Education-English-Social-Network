package evg.testt.service.impl;

import evg.testt.dao.EmployeeDao;
import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends BaseService<Employee, EmployeeDao> implements EmployeeService {

    public List<Employee> getByDepartment(Department department){
        return dao.findByDepartment(department);
    }

    public List<Employee> getByDepartment(Integer id){
        return dao.findByDepartment(Department.newBuilder().setId(id).build());
    }

}
