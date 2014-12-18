package com.gym.objects;

import com.gym.service.ProgramService;
import com.gym.service.WorkoutService;
import org.hibernate.ObjectNotFoundException;
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
    WorkoutService workoutService;

    @Autowired
    Program expectedProgram1;
    @Autowired
    Workout expectedWorkout1;
    @Autowired
    Workout expectedWorkout2;


    //@Ignore
    @Test(expected = ObjectNotFoundException.class)
    @Override
    public void crudTest() {
        programService.create(expectedProgram1);
        workoutService.create(expectedWorkout1);

        Workout readWorkout = workoutService.read(expectedWorkout1.getId());
        compare(readWorkout, expectedWorkout1);

        expectedWorkout1.setName("Name updated");

        workoutService.update(expectedWorkout1);
        readWorkout = workoutService.read(expectedWorkout1.getId());
        compare(readWorkout, expectedWorkout1);

        workoutService.create(expectedWorkout2);

        List<Workout> actualList = workoutService.readAll();

        List<Workout> expectedList = new LinkedList<Workout>();
        expectedList.add(expectedWorkout1);
        expectedList.add(expectedWorkout2);

        compareLists(expectedList, actualList);

        workoutService.delete(expectedWorkout1);
        workoutService.delete(expectedWorkout2);

        programService.delete(expectedProgram1);

        readWorkout = workoutService.read(expectedWorkout1.getId());
        readWorkout.toString();
    }

}
