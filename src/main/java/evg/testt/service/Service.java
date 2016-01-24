package evg.testt.service;

import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional
public interface Service<T> {
    List<T> getAll() throws SQLException;

    T getById(Integer id) throws SQLException;

    void delete(T o) throws SQLException;

    void insert(T o) throws SQLException;

    void update(T o) throws SQLException;

}
