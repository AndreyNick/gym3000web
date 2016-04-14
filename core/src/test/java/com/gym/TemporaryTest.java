package com.gym;

import com.gym.objects.Exercise;
import com.gym.objects.ExerciseTemplate;
import com.gym.objects.Program;
import com.gym.objects.ProgramTemplate;
import com.gym.service.ExerciseService;
import com.gym.service.ExerciseTemplateService;
import com.gym.service.ProgramService;
import com.gym.service.ProgramTemplateService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:temporary_test_context.xml")
public class TemporaryTest {

    @Autowired
    ProgramTemplateService programTemplateService;
    @Autowired
    ExerciseTemplateService exerciseTemplateService;
    @Autowired
    ProgramService programService;
    @Autowired
    ExerciseService exerciseService;

    @Autowired
    ExerciseTemplate exerciseTemplate1;
    @Autowired
    ExerciseTemplate exerciseTemplate2;
    @Autowired
    ProgramTemplate programTemplate1;
    @Autowired
    ProgramTemplate programTemplate2;
    @Autowired
    Exercise exercise1;
    @Autowired
    Exercise exercise2;
    @Autowired
    Program program1;
    @Autowired
    Program program2;

    @org.junit.Test
    public void test() {

        /*Long programTempId1 = programTemplateService.create(programTemplate1);
        Long programTempId2 = programTemplateService.create(programTemplate2);

        Long exerciseTempId1 = exerciseTemplateService.create(exerciseTemplate1);
        Long exerciseTempId2 = exerciseTemplateService.create(exerciseTemplate2);

        programTemplate1.addExerciseTemplate(exerciseTemplate1);
        programTemplateService.update(programTemplate1);*/
        //programTemplate1.addExerciseTemplate(exerciseTemplate1);
        //programTemplateService.update(programTemplate1);

        exerciseTemplateService.create(exerciseTemplate1);
        exerciseTemplateService.create(exerciseTemplate2);
        programService.create(program1);
        programService.create(program2);
        exercise1.setProgram(program1);

        exercise1.setExerciseTemplate(exerciseTemplate1);
        exercise2.setProgram(program2);
        exercise2.setExerciseTemplate(exerciseTemplate2);
        exerciseService.create(exercise1);
        exerciseService.create(exercise2);

    }


}
