package com.gym.objects;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by anni0913 on 28.11.2014.
 */
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public abstract class CrudGenericTest<T> extends AbstractSpringTest {

    public T getTestObject() {
        return testObject;
    }

    public void setTestObject(T testObject) {
        this.testObject = testObject;
    }

    protected T testObject;

    @Test
    public void testCR() {
        Long id = create(testObject);
        T selected = read(id);
        compare(selected, testObject);

    }

    public abstract Long create(T object);


    public abstract T read(Long id);


    public void compare(T selected, T testObject) {
        assertNotNull("selected is null", selected);
        assertTrue(selected.equals(testObject));
    }
}

