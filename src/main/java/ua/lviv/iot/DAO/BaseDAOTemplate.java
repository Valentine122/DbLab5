package ua.lviv.iot.DAO;

import org.hibernate.Session;
import java.sql.SQLException;
import java.util.List;

public interface BaseDAOTemplate<T, ID> {

    void create(T entity, Session session) throws SQLException;

    List<T> getAll(Session session) throws SQLException;

    T getBy(ID id, Session session) throws SQLException;

    void update(T entity, Session session) throws SQLException;

    void deleteBy(ID id, Session session) throws SQLException;
}
