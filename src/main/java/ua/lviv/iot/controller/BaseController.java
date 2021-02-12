package ua.lviv.iot.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.lviv.iot.service.BaseService;

import java.sql.SQLException;
import java.util.List;

@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
public abstract class BaseController<T, ID, SERVICE> implements ControllerTemplate<T, ID>{

    BaseService service;
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();

        } catch (Throwable throwable){
            throw new ExceptionInInitializerError(throwable);
        }
    }

    BaseController(Class<SERVICE> currentClass) {
        try {
            service = (BaseService) currentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void create(T entity) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            service.create(entity, session);
        }
    }

    @Override
    public List<T> findAll() throws SQLException {
        List<T> entities = null;
        try (Session session = sessionFactory.openSession()){
            entities = service.findAll(session);
        }
        return entities;
    }

    @Override
    public T findBy(ID id) throws SQLException {
        T entity = null;
        try(Session session = sessionFactory.openSession()){
            entity = (T) service.findBy(id, session);
        }
        return entity;
    }

    @Override
    public void deleteBy(ID id) throws SQLException {
        try(Session session = sessionFactory.openSession()){
            service.deleteBy(id, session);
        }
    }

    @Override
    public void update(T entity) throws SQLException {
        try(Session session = sessionFactory.openSession()){
            service.update(entity, session);
        }
    }

}
