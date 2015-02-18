package com.gym.objects;

import com.gym.service.ProgramService;
import com.gym.service.WorkoutService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by anni0913 on 22.12.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test_config.xml")
public class SimpleTest {
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

    @Ignore
    @Test
    public void test(){
        programService.create(expectedProgram1);
        workoutService.create(expectedExerciseType1);
        workoutService.create(expectedExerciseType2);

        Program program = programService.read(expectedProgram1.getId());
        List<ExerciseType> exerciseTypeList =  program.getWorkoutList();
        for(ExerciseType item: exerciseTypeList){
            System.out.println(item.getName());
        }
    }

}
