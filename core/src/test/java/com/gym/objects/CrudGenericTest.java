package com.gym.objects;

import org.junit.Ignore;
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
public abstract class CrudGenericTest<T, PK> extends AbstractSpringTest {

    public T getTestObject() {
        return testObject;
    }

    public void setTestObject(T testObject) {
        this.testObject = testObject;
    }

    protected T testObject;
    private Long testId;

  /*  @Ignore
    @Test
    public void testCR() {
        PK id = create(testObject);
        T selected = read(id);
        compare(selected, testObject);

    }*/

    @Test
    public void create(){
        PK id = create(testObject);
        System.out.println(id + "\n");
        testId = (Long)id;
        assertNotNull(id);
    }

    @Test
    public void read(){
        T selected = read((PK) testId);
        compare(selected, testObject);
    }



    public abstract PK create(T object);


    public abstract T read(PK id);


    public void compare(T selected, T testObject) {
        assertNotNull("selected is null", selected);
        assertTrue(selected.equals(testObject));
    }
}

