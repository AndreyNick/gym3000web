package com.gym;

import com.gym.objects.Exercise;
import com.gym.objects.ExerciseTemplate;
import com.gym.objects.Program;
import com.gym.objects.ProgramTemplate;
import com.gym.service.ExerciseService;
import com.gym.service.ExerciseTemplateService;
import com.gym.service.ProgramService;
import com.gym.service.ProgramTemplateService;
import junit.framework.Assert;
import org.junit.Test;
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
    ExerciseTemplate exerciseTemplate;

    @Autowired
    ProgramTemplate programTemplate;

    @Autowired
    Exercise exercise;

    @Autowired
    Program program;


    //@Test
    public void test() {
        //programService.create(program1);
        //exerciseTemplateService.create(exerciseTemplate1);

        //exercise1.setProgram(programService.read((long) 1));
        //exercise1.setExerciseTemplate(exerciseTemplateService.read((long) 1));
        //exerciseService.create(exercise1);
        System.out.println(exerciseService.read((long) 1));
    }


    /*
    *ExerciseTemplate could be created without ProgramTemplate
    */

    @Test
    public void createReadExerciseTemplate() {
        exerciseTemplateService.create(exerciseTemplate);
        ExerciseTemplate et = exerciseTemplateService.read(exerciseTemplate.getId());
        Assert.assertEquals(exerciseTemplate, et);
    }

    /**
     * ProgramTemplate could be created without ExerciseTemplates list
     */
    @Test
    public void createReadProgramTemplate() {
        programTemplateService.create(programTemplate);
        ProgramTemplate pt = programTemplateService.read(programTemplate.getId());
        Assert.assertEquals(programTemplate, pt);
    }

    @Test
    public void createReadProgram() {
        programService.create(program);
        Program p = programService.read(program.getId());
        Assert.assertEquals(program, p);
    }

    @Test
    public void createReadExercise() {
        exercise.setExerciseTemplate(exerciseTemplate);
        exercise.setProgram(program);
        exerciseService.create(exercise);
        Exercise e = exerciseService.read(exercise.getId());
        Assert.assertEquals(exercise, e);
    }

    @Test
    public void updateExerciseTemplate() {
        exerciseTemplate.setName("name was changed");
        exerciseTemplateService.update(exerciseTemplate);
        ExerciseTemplate et = exerciseTemplateService.read(exerciseTemplate.getId());
        Assert.assertEquals(exerciseTemplate, et);
    }

    @Test
    public void updateProgramTemplate() {
        programTemplate.setName("name was changed");
        programTemplateService.update(programTemplate);
        ProgramTemplate pt = programTemplateService.read(programTemplate.getId());
        Assert.assertEquals(programTemplate, pt);
    }
}
