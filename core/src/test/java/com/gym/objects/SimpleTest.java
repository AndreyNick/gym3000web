package com.gym.objects;

import com.gym.service.ProgramService;
import com.gym.service.WorkoutService;
import org.junit.Ignore;
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
    Workout expectedWorkout1;
    @Autowired
    Workout expectedWorkout2;

    @Ignore
    @org.junit.Test
    public void test(){
        programService.create(expectedProgram1);
        workoutService.create(expectedWorkout1);
        workoutService.create(expectedWorkout2);

        Program program = programService.read(expectedProgram1.getId());
        List<Workout> workoutList =  program.getWorkoutList();
        for(Workout item:workoutList){
            System.out.println(item.getName());
        }
    }

}
