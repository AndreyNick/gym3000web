package com.gym.service;

import com.gym.dao.GenericDao;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anni0913 on 28.11.2014.
 */
public class AbstractGenericService<T, PK extends Serializable> {

    private GenericDao<T, PK> dao;

    protected AbstractGenericService(GenericDao<T, PK> dao) {
        this.dao = dao;
    }

    @Transactional
    public PK create(T object) {
        return dao.create(object);
    }

    @Transactional
    public T read(PK id) {
        return dao.read(id);
    }

    @Transactional
    public void update(T object) {
        dao.update(object);
    }

    @Transactional
    public void delete(T object) {
        dao.delete(object);
    }

    @Transactional
    public List<T> readAll() {
        return dao.readAll();
    }
}
