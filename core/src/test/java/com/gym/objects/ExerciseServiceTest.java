package com.gym.objects;

import com.gym.service.ExerciseService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by anni0913 on 08.12.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test_config.xml")
public class ExerciseServiceTest extends AbstractServiceTest{

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    //Exercise testExercise;



    @Override
    @Test
    @Ignore
    public void crudTest() {

    }

}
