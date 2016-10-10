package com.gym;

import com.gym.objects.HasIdAndName;
import com.gym.service.AbstractGenericService;
import junit.framework.Assert;
import org.hibernate.ObjectNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * Generic test class provides general scope of test methods
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:generic_test_context.xml")
public abstract class GenericTest {

    HasIdAndName expected;
    AbstractGenericService service;

    @Before
    public abstract void init();

    public void saveTransientObjectsIfNeed() {}

    public void setExpected(HasIdAndName expected) {
        this.expected = expected;
    }

    public void setService(AbstractGenericService service) {
        this.service = service;
    }

    @Test
    @Transactional
    @Rollback(true)
    public void createAndReadEntity() {
        saveTransientObjectsIfNeed();
        service.create(expected);
        Assert.assertEquals(expected, service.read(expected.getId()));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateEntity() {
        saveTransientObjectsIfNeed();
        service.create(expected);
        expected.setName("name was changed");
        service.update(expected);
        Assert.assertEquals(expected, service.read(expected.getId()));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void deleteEntity() throws ObjectNotFoundException {
        saveTransientObjectsIfNeed();
        service.create(expected);
        Long id = expected.getId();
        service.delete(expected);
        service.read(id);
    }
}
