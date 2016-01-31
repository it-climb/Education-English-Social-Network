package evg.testt.service;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService extends Service<Employee> {

    //@Override
    //List<Employee> getAll() throws SQLException;

    @Override
    @Cacheable(value = "employeesCache", key = "#id")
    Employee getById(Integer id) throws SQLException;

    @Override
    @CacheEvict(value = "employeesCache", key = "#p0.id")
    void delete(Employee o) throws SQLException;

    //@Override
    //@CacheEvict(value = "employeesCache", key = "#p0.id")
    //void insert(Employee o) throws SQLException;

    @Override
    @CacheEvict(value = "employeesCache", key = "#p0.id")
    void update(Employee o) throws SQLException;

    List<Employee> getByDepartment(Department department);

    List<Employee> getByDepartment(Integer department);

}
