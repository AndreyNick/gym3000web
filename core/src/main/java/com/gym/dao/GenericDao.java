package com.gym.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interface of generic DAO class for simple crud operations
 */
public interface GenericDao <T, PK extends Serializable> {

    /**
     * Persist the newInstance object into database
     *
     * @param newInstance object
     * @return primary key (id)
     */
    PK create(T newInstance);

    /**
     * Retrieve an object that was previously persisted to the database
     *
     * @param id primary key
     * @return stored object
     */
    T read(PK id);

    /**
     * Save changes made to a persistent object
     *
     * @param transientObject object
     */
    void update(T transientObject);

    /**
     * Remove an object from persistent storage in the database
     *
     * @param persistentObject object
     */
    void delete(T persistentObject);

    /**
     * Retrieve all object certain type
     *
     * @return all object from table
     */
    List<T> readAll();
}
