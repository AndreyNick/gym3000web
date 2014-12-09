package com.gym.objects;

import com.gym.service.ProgramService;
import com.gym.service.WorkoutService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNull;

/**
 * Created by anni0913 on 08.12.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test_config.xml")
public class WorkoutServiceTest extends AbstractServiceTest{

    @Autowired
    WorkoutService workoutService;

    @Autowired
    Workout testWorkout;

    @Autowired
    ProgramService programService;

    @Autowired
    Program testProgram;


    @Ignore
    @Override
    @Test
    //@Ignore
    public void crudTest() {
        programService.create(testProgram);
        workoutService.create(testWorkout);

        /*Workout readWorkout = workoutService.read(testWorkout.getId());
        compare(readWorkout, testWorkout);*/

        workoutService.update(testWorkout);
        Workout readWorkout = (Workout)workoutService.read(testWorkout.getId());
        compare(readWorkout, testWorkout);

        workoutService.delete(testWorkout);
        //programService.delete(testProgram);
        readWorkout = workoutService.read(testWorkout.getId());
        assertNull(readWorkout);

    }

    @Override
    @Test
    @Ignore
    public void readAllTest() {

    }
}
