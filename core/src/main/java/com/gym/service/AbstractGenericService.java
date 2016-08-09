package com.gym.service;

import com.gym.dao.GenericDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Service
public class AbstractGenericService<T, PK extends Serializable> {

    protected GenericDao<T, PK> dao;

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
