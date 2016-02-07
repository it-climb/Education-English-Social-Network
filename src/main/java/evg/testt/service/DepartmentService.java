package evg.testt.service;

import evg.testt.model.Department;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentService extends Service<Department>{

    @Override
    @Cacheable(value = "departmentsAllCache" , key = "'getAll'")
    List<Department> getAll() throws SQLException;

    @Override
    Department getById(Integer id) throws SQLException;

    @Override
    @CacheEvict(value = "departmentsAllCache", key = "'getAll'")
    void delete(Department o) throws SQLException;

    @Override
    @CacheEvict(value = "departmentsAllCache", key = "'getAll'")
    Department update(Department o) throws SQLException;

    @Override
    @CacheEvict(value = "departmentsAllCache", key = "'getAll'")
    Department insert(Department o) throws SQLException;
}
