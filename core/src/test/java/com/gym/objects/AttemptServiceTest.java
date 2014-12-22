package com.gym.objects;

import com.gym.service.AttemptService;
import com.gym.service.ExerciseService;
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

/**
 * Created by anni0913 on 08.12.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test_config.xml")
public class AttemptServiceTest extends AbstractServiceTest{

    @Autowired
    ProgramService programService;
    @Autowired
    WorkoutService workoutService;
    @Autowired
    ExerciseService exerciseService;
    @Autowired
    AttemptService attemptService;


    @Autowired
    Program expectedProgram1;
    @Autowired
    Workout expectedWorkout1;
    @Autowired
    Exercise expectedExercise1;

    @Autowired
    Attempt expectedAttempt1;
    @Autowired
    Attempt expectedAttempt2;

    //@Ignore
    @Override
    @Test(expected = ObjectNotFoundException.class)
    public void crudTest() {
        programService.create(expectedProgram1);
        workoutService.create(expectedWorkout1);
        exerciseService.create(expectedExercise1);
        idNotNull(attemptService.create(expectedAttempt1));

        Attempt actualAttempt = attemptService.read(expectedAttempt1.getId());
        compare(actualAttempt, expectedAttempt1);

        expectedAttempt1.setWeight(28);

        attemptService.update(expectedAttempt1);
        actualAttempt = attemptService.read(expectedAttempt1.getId());
        compare(actualAttempt, expectedAttempt1);

        attemptService.create(expectedAttempt2);

        List<Attempt> actualList = attemptService.readAll();

        List<Attempt> expectedList = new LinkedList<Attempt>();
        expectedList.add(expectedAttempt1);
        expectedList.add(expectedAttempt2);

        compareLists(expectedList, actualList);

        attemptService.delete(expectedAttempt1);
        attemptService.delete(expectedAttempt2);

        exerciseService.delete(expectedExercise1);
        workoutService.delete(expectedWorkout1);
        programService.delete(expectedProgram1);

        actualAttempt = attemptService.read(expectedAttempt1.getId());
        actualAttempt.toString();
    }

}
