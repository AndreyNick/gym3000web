package com.gym;

import com.gym.objects.*;
import com.gym.service.*;
import junit.framework.Assert;

import org.hibernate.ObjectNotFoundException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:generic_test_context.xml")
public class SetTest {

    @Autowired
    SetService setService;
    @Autowired
    ExerciseService exerciseService;
    @Autowired
    ExerciseTemplateService exerciseTemplateService;
    @Autowired
    ProgramService programService;
    @Autowired
    OwnerService ownerService;
    @Autowired
    Owner owner1;
    @Autowired
    Exercise exercise1;
    @Autowired
    ExerciseTemplate exerciseTemplate1;
    @Autowired
    Set set;
    @Autowired
    Program program1;

    @Before()
    public void before() {
        ownerService.create(owner1);
        programService.create(program1);
        exerciseTemplateService.create(exerciseTemplate1);
        exerciseService.create(exercise1);
        setService.create(set);
    }

    @After()
    public void after() {
        setService.delete(set);
        exerciseService.delete(exercise1);
        exerciseTemplateService.delete(exerciseTemplate1);
        programService.delete(program1);
        ownerService.delete(owner1);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void createAndReadEntity() {
        Set actual = setService.read(set.getId());
        Assert.assertEquals(actual, set);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateEntity() {
        set.setWeight(100);
        setService.update(set);
        Set actual = setService.read(set.getId());
        Assert.assertEquals(set, actual);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void deleteEntity() throws ObjectNotFoundException {
        Set actual = setService.read(set.getId());
        Assert.assertEquals(set, actual);
        setService.delete(set);
        setService.read(set.getId());
    }
}
