package com.gym.objects;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by anni0913 on 08.12.2014.
 */
public abstract class AbstractServiceTest<T> {

    public abstract void crudTest();

    public abstract void readAllTest();

    public void compare(T selected, T testObject) {
        assertNotNull("selected is null", selected);
        assertTrue(selected.equals(testObject));
    }
}
