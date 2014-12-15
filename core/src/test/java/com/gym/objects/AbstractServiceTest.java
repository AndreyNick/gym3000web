package com.gym.objects;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by anni0913 on 08.12.2014.
 */
public abstract class AbstractServiceTest<T> {

    public abstract void crudTest();

    public void compare(T expected, T actual) {
        assertNotNull("expected is null", expected);
        assertTrue(expected.equals(actual));
    }

    public void idNotNull(Long id){
        assertNotNull("selected is null", id);
        assertNotSame(new Long("0"), id);
    }

    public List set3ObjectToList(Object object){
        List list = new LinkedList();
        for(int i = 0; i < 3; i++){
            list.add(object);
        }
        return list;
    }

    public void compareLists(List<T> expected, List<T> actual){
        assertEquals(expected.size(), actual.size());
        for(T item: expected){
            assertTrue(actual.contains(item));
        }
    }

}
