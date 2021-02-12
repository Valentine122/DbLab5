package ua.lviv.iot.DAO;

import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation", "rawtypes"})
public abstract class BaseDAO<T, ID> implements BaseDAOTemplate<T, ID> {

    private final Class<T> currentClass;

    public BaseDAO(Class<T> currentClass) {
        this.currentClass = currentClass;

    }

    @Override
    public void create(T entity, Session session) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public List<T> getAll(Session session) throws SQLException {
        List<T> entities = new LinkedList<>();
        Query query = session.createQuery("FROM " + currentClass.getSimpleName());
        for (Object entity : query.getResultList()) {
            entities.add((T) entity);
        }
        return entities;
    }

    @Override
    public T getBy(ID id, Session session) throws SQLException {
        return session.get(currentClass, (Integer) id);
    }


    @Override
    public void update(T entity, Session session) throws SQLException {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteBy(ID id, Session session) throws SQLException {
        session.beginTransaction();
        T deletedEntity = getBy(id, session);
        session.delete(deletedEntity);
        session.getTransaction().commit();
    }

}
