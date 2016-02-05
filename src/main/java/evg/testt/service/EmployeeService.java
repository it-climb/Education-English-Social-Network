package evg.testt.service;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService extends Service<Employee> {

    List<Employee> getByDepartment(Department department);

    List<Employee> getByDepartment(Integer department);

}
