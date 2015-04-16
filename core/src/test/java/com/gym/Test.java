package com.gym;

import com.gym.objects.*;
import com.gym.service.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test class for inner checking
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test_context.xml")
public class Test {
    @Autowired
    OwnerService ownerService;
    @Autowired
    TrainingService trainingService;
    @Autowired
    ExerciseService exerciseService;
    @Autowired
    AttemptService attemptService;
    @Autowired
    ProgramService programService;
    @Autowired
    ExerciseTypeService exerciseTypeService;
    @Autowired
    Owner owner;
    @Autowired
    Training training;
    @Autowired
    Program program;
    @Autowired
    ExerciseType exerciseType;
    @Autowired
    Exercise exercise;
    @Autowired
    Attempt attempt;


    @org.junit.Test
    public void test(){
        ownerService.create(owner);
        programService.create(program);
        exerciseTypeService.create(exerciseType);
        trainingService.create(training);
        exerciseService.create(exercise);
        attemptService.create(attempt);
    }
}