package com.gym;

import com.gym.objects.Exercise;
import com.gym.objects.ExerciseTemplate;
import com.gym.objects.Program;
import com.gym.service.ExerciseService;
import com.gym.service.ExerciseTemplateService;
import com.gym.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test class for ExerciseService
 */
public class ExerciseTest extends GenericTest {

    @Autowired
    ExerciseService exerciseService;
    @Autowired
    Exercise exercise;
    @Autowired
    ProgramService programService;
    @Autowired
    Program program1;
    @Autowired
    ExerciseTemplateService exerciseTemplateService;
    @Autowired
    ExerciseTemplate exerciseTemplate1;

    @Override
    public void init() {
        setExpected(exercise);
        setService(exerciseService);
    }

    @Override
    public void saveTransientObjectsIfNeed() {
        exerciseTemplateService.create(exerciseTemplate1);
        programService.create(program1);
    }
}
