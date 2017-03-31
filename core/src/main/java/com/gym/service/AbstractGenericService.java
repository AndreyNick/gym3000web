package com.gym.service;

import com.gym.dao.GenericDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


/**
 * Generic service
 */
@Service
@Transactional
public class AbstractGenericService<T, PK extends Serializable> {

    protected GenericDao<T, PK> dao;

    protected AbstractGenericService(GenericDao<T, PK> dao) {
        this.dao = dao;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public PK create(T object) {
        return dao.create(object);
    }

    @Transactional(readOnly = true)
    public T read(PK id) {
        return dao.read(id);
    }


    public void update(T object) {
        dao.update(object);
    }


    public void delete(T object) {
        dao.delete(object);
    }

    @Transactional(readOnly = true)
    public List<T> readAll() {
        return dao.readAll();
    }
}
