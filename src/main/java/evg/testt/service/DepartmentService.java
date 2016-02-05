package evg.testt.service;

import evg.testt.model.Department;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentService extends Service<Department>{

    @Override
//    @CacheEvict(value = "departmentsAllCache")
    @Cacheable(value = "departmentsAllCache")
    List<Department> getAll() throws SQLException;

    @Override
    Department getById(Integer id) throws SQLException;

    @Override
    @CacheEvict(value = "departmentsAllCache", allEntries = true, key = "id")
    void delete(Department o) throws SQLException;

    @Override
    @CacheEvict(value = "departmentsAllCache", key = "#id", allEntries = true)
    void update(Department o) throws SQLException;

    @Override
    @CacheEvict(value = "departmentsAllCache", key = "#id", allEntries = true)
    void insert(Department o) throws SQLException;
}
