package com.gym.objects;

import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by anni0913 on 28.11.2014.
 */
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public abstract class CrudGenericTest<T, PK> extends AbstractSpringTest {



    protected T testObject;
    protected T parentObject;

    public T getTestObject() {
        return testObject;
    }

    public void setTestObject(T testObject) {
        this.testObject = testObject;
    }

    @Test
    public void testCRUD() {
        PK id = create(testObject);
        T selected = read(id);
        System.out.println(selected.toString());
        compare(selected, testObject);

       /* update(testObject);
        T updated = read(id);
        System.out.println(updated.toString());
        compare(updated, testObject);

        delete(testObject);
        T deleted = read(id);
        System.out.println(deleted.toString());
        assertNull(deleted);*/
    }

    @Ignore
    @Test
    public void testReadAll(){
        PK id1 = create(testObject);
        PK id2 = create(testObject);
        PK id3 = create(testObject);
        List<T> testObjectsList = new LinkedList<T>();
        testObjectsList.add(testObject);
        testObjectsList.add(testObject);
        testObjectsList.add(testObject);
        List<T> selectedObjectsList = readAll();

        for(int i = 0; i<testObjectsList.size(); i++){
            compare(selectedObjectsList.get(i), testObjectsList.get(i));
        }
    }

    @AfterClass
    public static void afterClass(){

        System.out.println("afterClass");
    }

    public abstract PK create(T object);

    public abstract T read(PK id);

    public abstract void update(T object);

    public abstract void delete(T object);

    public abstract List<T> readAll();


    public void compare(T selected, T testObject) {
        assertNotNull("selected is null", selected);
        assertTrue(selected.equals(testObject));
    }
}

