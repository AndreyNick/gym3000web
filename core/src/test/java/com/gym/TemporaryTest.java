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
import org.hibernate.ObjectNotFoundException;
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


    @Test
    public void test() {

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

    @Test
    public void updateProgram() {
        program.setName("name was changed");
        programService.update(program);
        Program p = programService.read(program.getId());
        Assert.assertEquals(program, p);
    }

    @Test
    public void updateExercise() {
        exercise.setName("name was changed");
        exerciseService.update(exercise);
        Exercise e = exerciseService.read(exercise.getId());
        Assert.assertEquals(exercise, e);
    }

    @Test
     public void deleteExerciseTemplate() throws ObjectNotFoundException{
        exerciseTemplateService.delete(exerciseTemplate);
        exerciseTemplateService.read(exerciseTemplate.getId());
    }

    @Test
    public void deleteExercise() throws ObjectNotFoundException{
        exerciseService.delete(exercise);
        exerciseService.read(exercise.getId());
    }

    @Test
    public void deleteProgramTemplate() throws ObjectNotFoundException{
        programTemplateService.delete(programTemplate);
        programTemplateService.read(programTemplate.getId());
    }

    @Test
    public void deleteProgram() throws ObjectNotFoundException{
        programService.delete(program);
        programService.read(program.getId());
    }

}
