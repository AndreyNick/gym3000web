package com.gym.dao.impl;

import com.gym.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Implementation of generic DAO class for simple crud operations
 */
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    private Class<T> type;
    private SessionFactory sessionFactory;

    protected GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public PK create(T newInstance) {
        return (PK) getSession().save(newInstance);
    }

    @Override
    public T read(PK id) {
        return (T) getSession().load(type, id);
    }

    @Override
    public void update(T transientObject) {
        getSession().update(transientObject);
    }

    @Override
    public void delete(T persistentObject) {
        getSession().delete(persistentObject);
    }

    @Override
    public List<T> readAll() {
        return getSession().createCriteria(type).list();
    }

    private Session getSession(){
        return sessionFactory.openSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
