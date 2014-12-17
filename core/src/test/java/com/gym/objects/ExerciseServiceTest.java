package com.gym.objects;

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
public class ExerciseServiceTest extends AbstractServiceTest{

    @Autowired
    ProgramService programService;
    @Autowired
    WorkoutService workoutService;
    @Autowired
    ExerciseService exerciseService;


    @Autowired
    Program expectedProgram1;
    @Autowired
    Workout expectedWorkout1;

    @Autowired
    Exercise expectedExercise1;
    @Autowired
    Exercise expectedExercise2;

    //@Ignore
    @Override
    @Test(expected = ObjectNotFoundException.class)
    public void crudTest() {
        programService.create(expectedProgram1);
        workoutService.create(expectedWorkout1);
        exerciseService.create(expectedExercise1);

        Exercise actualExercise = exerciseService.read(expectedExercise1.getId());
        compare(actualExercise, expectedExercise1);

        expectedExercise1.setType("Type updated");

        exerciseService.update(expectedExercise1);
        actualExercise = exerciseService.read(expectedExercise1.getId());
        compare(actualExercise, expectedExercise1);

        exerciseService.create(expectedExercise2);

        List<Exercise> actualList = exerciseService.readAll();

        List<Exercise> expectedList = new LinkedList<Exercise>();
        expectedList.add(expectedExercise1);
        expectedList.add(expectedExercise2);

        compareLists(expectedList, actualList);

        exerciseService.delete(expectedExercise1);
        exerciseService.delete(expectedExercise2);

        workoutService.delete(expectedWorkout1);

        programService.delete(expectedProgram1);

        actualExercise = exerciseService.read(expectedExercise1.getId());
        actualExercise.toString();
    }

}
