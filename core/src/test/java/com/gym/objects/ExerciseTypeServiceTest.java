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
public class ExerciseTypeServiceTest extends AbstractServiceTest{


    @Autowired
    ProgramService programService;
    @Autowired
    WorkoutService workoutService;

    @Autowired
    Program expectedProgram1;
    @Autowired
    ExerciseType expectedExerciseType1;
    @Autowired
    ExerciseType expectedExerciseType2;


    //@Ignore
    @Test(expected = ObjectNotFoundException.class)
    @Override
    public void crudTest() {
        programService.create(expectedProgram1);
        idNotNull(workoutService.create(expectedExerciseType1));

        ExerciseType readExerciseType = workoutService.read(expectedExerciseType1.getId());
        compare(readExerciseType, expectedExerciseType1);

        expectedExerciseType1.setName("Name updated");

        workoutService.update(expectedExerciseType1);
        readExerciseType = workoutService.read(expectedExerciseType1.getId());
        compare(readExerciseType, expectedExerciseType1);

        workoutService.create(expectedExerciseType2);

        List<ExerciseType> actualList = workoutService.readAll();

        List<ExerciseType> expectedList = new LinkedList<ExerciseType>();
        expectedList.add(expectedExerciseType1);
        expectedList.add(expectedExerciseType2);

        compareLists(expectedList, actualList);

        workoutService.delete(expectedExerciseType1);
        workoutService.delete(expectedExerciseType2);

        programService.delete(expectedProgram1);

        readExerciseType = workoutService.read(expectedExerciseType1.getId());
        readExerciseType.toString();
    }

}
