package com.gym.objects;

import com.gym.service.ProgramService;
import com.gym.service.WorkoutService;
import org.hibernate.ObjectNotFoundException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertNull;

/**
 * Created by anni0913 on 08.12.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test_config.xml")
public class WorkoutServiceTest extends AbstractServiceTest{


    @Autowired
    ProgramService programService;
    @Autowired
    Program testProgram1;

    @Autowired
    WorkoutService workoutService;
    @Autowired
    Workout testWorkout1;
    @Autowired
    Workout testWorkout2;


    //@Ignore
    @Test(expected = ObjectNotFoundException.class)
    @Override
    public void crudTest() {
        programService.create(testProgram1);
        workoutService.create(testWorkout1);

        Workout readWorkout = workoutService.read(testWorkout1.getId());
        compare(readWorkout, testWorkout1);

        testWorkout1.setName("Name updated");

        workoutService.update(testWorkout1);
        readWorkout = workoutService.read(testWorkout1.getId());
        compare(readWorkout, testWorkout1);

        workoutService.create(testWorkout2);

        List<Workout> actualList = workoutService.readAll();

        List<Workout> expectedList = new LinkedList<Workout>();
        expectedList.add(testWorkout1);
        expectedList.add(testWorkout2);

        compareLists(expectedList, actualList);

        workoutService.delete(testWorkout1);
        workoutService.delete(testWorkout2);

        programService.delete(testProgram1);

        readWorkout = workoutService.read(testWorkout1.getId());
        readWorkout.toString();

    }

}
