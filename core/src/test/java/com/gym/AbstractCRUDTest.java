package com.gym;

import com.gym.objects.HasIdAndName;
import com.gym.service.AbstractGenericService;
import junit.framework.Assert;
import org.junit.Test;


public class AbstractCRUDTest {

    private HasIdAndName expected;
    private AbstractGenericService<HasIdAndName, java.io.Serializable> service;

    protected void setExpected(HasIdAndName expected) {
        this.expected = expected;
    }

    protected void setService(AbstractGenericService<HasIdAndName, java.io.Serializable> service) {
        this.service = service;
    }

    @Test
    public void createRead() {
        service.create(expected);
        HasIdAndName actual = service.read(expected.getId());
        Assert.assertEquals(expected, actual);
    }
}
