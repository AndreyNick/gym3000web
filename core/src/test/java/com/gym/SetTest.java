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
    UserService userService;
    @Autowired
    User user1;
    @Autowired
    Exercise exercise1;
    @Autowired
    ExerciseTemplate exerciseTemplate1;
    @Autowired
    Set set;
    @Autowired
    Program program1;


    @Test
    @Transactional
    @Rollback(true)
    public void createAndReadEntity() {
        userService.create(user1);
        programService.create(program1);
        exerciseTemplateService.create(exerciseTemplate1);
        exerciseService.create(exercise1);
        setService.create(set);
        Set actual = setService.read(set.getId());
        Assert.assertEquals(actual, set);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateEntity() {
        userService.create(user1);
        programService.create(program1);
        exerciseTemplateService.create(exerciseTemplate1);
        exerciseService.create(exercise1);
        setService.create(set);
        set.setWeight(100);
        setService.update(set);
        Assert.assertEquals(set, setService.read(set.getId()));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void deleteEntity() throws ObjectNotFoundException {
        userService.create(user1);
        programService.create(program1);
        exerciseTemplateService.create(exerciseTemplate1);
        exerciseService.create(exercise1);
        setService.create(set);
        Long id = set.getId();
        setService.delete(set);
        setService.read(id);
    }
}
