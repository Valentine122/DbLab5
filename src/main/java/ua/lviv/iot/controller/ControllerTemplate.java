package ua.lviv.iot.controller;

import java.sql.SQLException;
import java.util.List;

public interface ControllerTemplate<T, ID> {

    void create(T entity) throws SQLException;

    List<T> findAll() throws SQLException;

    T findBy(ID id) throws SQLException;

    void update(T entity) throws SQLException;

    void deleteBy(ID id) throws SQLException;

}
