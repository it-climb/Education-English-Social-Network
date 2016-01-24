package evg.testt.dao;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByDepartment(Department department);

}
