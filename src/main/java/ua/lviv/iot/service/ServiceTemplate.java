package ua.lviv.iot.service;

import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface ServiceTemplate<T, ID> {

    void create(T entity, Session session) throws SQLException;

    List<T> findAll(Session session) throws SQLException;

    T findBy(ID id, Session session) throws SQLException;

    void update(T entity, Session session) throws SQLException;

    void deleteBy(ID id, Session session) throws SQLException;

}
