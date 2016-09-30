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

import java.sql.Date;


//@RunWith(SpringJUnit4ClassRunner.class)
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
    ProgramTemplate programTemplate1;
    @Autowired
    ExerciseTemplate exerciseTemplate2;
    @Autowired
    ProgramTemplate programTemplate2;
    @Autowired
    Exercise exercise;
    @Autowired
    Program program;



    //@Test
    public void multipleBindSameExerciseTemplate() {
        programTemplateService.create(programTemplate1);
        programTemplateService.create(programTemplate2);
        exerciseTemplateService.create(exerciseTemplate1);
        exerciseTemplateService.create(exerciseTemplate2);

        ProgramTemplate pt = programTemplateService.read(programTemplate1.getId());
        ExerciseTemplate et = exerciseTemplateService.read(exerciseTemplate1.getId());
        pt.addExerciseTemplate(et);
        pt.addExerciseTemplate(et);
        programTemplateService.update(pt);
        pt.addExerciseTemplate(et);
        programTemplateService.update(pt);
    }


    /*
    *ExerciseTemplate could be created without ProgramTemplate
    */

    //@Test
    public void createReadExerciseTemplate() {
        exerciseTemplateService.create(exerciseTemplate1);
        ExerciseTemplate et = exerciseTemplateService.read(exerciseTemplate1.getId());
        Assert.assertEquals(exerciseTemplate1, et);
    }

    /**
     * ProgramTemplate could be created without ExerciseTemplates list
     */
    //@Test
    public void createReadProgramTemplate() {
        programTemplateService.create(programTemplate1);
        ProgramTemplate pt = programTemplateService.read(programTemplate1.getId());
        Assert.assertEquals(programTemplate1, pt);
    }

    //@Test
    public void createReadProgram() {
        programService.create(program);
        Program p = programService.read(program.getId());
        Assert.assertEquals(program, p);
    }

    //@Test
    public void createReadExercise() {
        exercise.setExerciseTemplate(exerciseTemplate1);
        exercise.setProgram(program);
        exerciseService.create(exercise);
        Exercise e = exerciseService.read(exercise.getId());
        Assert.assertEquals(exercise, e);
    }

    //@Test
    public void updateExerciseTemplate() {
        exerciseTemplateService.create(exerciseTemplate1);
        exerciseTemplate1.setName("name was changed");
        exerciseTemplateService.update(exerciseTemplate1);
        ExerciseTemplate et = exerciseTemplateService.read(exerciseTemplate1.getId());
        Assert.assertEquals(exerciseTemplate1, et);
    }

    //@Test
    public void updateProgramTemplate() {
        programTemplateService.create(programTemplate1);
        programTemplate1.setName("name was changed");
        programTemplateService.update(programTemplate1);
        ProgramTemplate pt = programTemplateService.read(programTemplate1.getId());
        Assert.assertEquals(programTemplate1, pt);
    }

    //@Test
    public void updateProgram() {
        programService.create(program);
        program.setName("name was changed");
        programService.update(program);
        Program p = programService.read(program.getId());
        Assert.assertEquals(program, p);
    }

    //@Test
    public void updateExercise() {
        exerciseService.create(exercise);
        exercise.setName("name was changed");
        exerciseService.update(exercise);
        Exercise e = exerciseService.read(exercise.getId());
        Assert.assertEquals(exercise, e);
    }

    //@Test
     public void deleteExerciseTemplate() throws ObjectNotFoundException {
        exerciseTemplateService.create(exerciseTemplate1);
        ExerciseTemplate et = exerciseTemplateService.read(exerciseTemplate1.getId());
        Assert.assertEquals(exerciseTemplate1, et);
        exerciseTemplateService.delete(exerciseTemplate1);
        exerciseTemplateService.read(exerciseTemplate1.getId());
    }

    //@Test
    public void deleteExercise() throws ObjectNotFoundException {
        exerciseService.create(exercise);
        Exercise e = exerciseService.read(exercise.getId());
        Assert.assertEquals(exercise, e);
        exerciseService.delete(exercise);
        exerciseService.read(exercise.getId());
    }

    //@Test
    public void deleteProgramTemplate() throws ObjectNotFoundException {
        programTemplateService.create(programTemplate1);
        ProgramTemplate pt = programTemplateService.read(programTemplate1.getId());
        Assert.assertEquals(programTemplate1, pt);
        programTemplateService.delete(programTemplate1);
        programTemplateService.read(programTemplate1.getId());
    }

    //@Test
    public void deleteProgram() throws ObjectNotFoundException {
        programService.create(program);
        Program p = programService.read(program.getId());
        Assert.assertEquals(program, p);
        programService.delete(program);
        programService.read(program.getId());
    }


    //@Test
    public void equalsProgramMethodsTest() {
        /*Program legsDayProgram = new Program("Legs day", new Date(System.currentTimeMillis()));
        ExerciseTemplate pushUpsT = new ExerciseTemplate("Push Ups T");
        Exercise pushUps1 = new Exercise(legsDayProgram, pushUpsT, "Push Ups 1");
        Exercise pushUps2 = new Exercise(legsDayProgram, pushUpsT, "Push Ups 2");
        exerciseTemplateService.create(pushUpsT);
        programService.create(legsDayProgram);
        exerciseService.create(pushUps1);
        exerciseService.create(pushUps2);
        System.out.println(legsDayProgram);
        System.out.println(pushUpsT);
        System.out.println(pushUps1);
        System.out.println("============");
        System.out.println(programService.read(legsDayProgram.getId()));
        System.out.println(exerciseTemplateService.read(pushUpsT.getId()));
        System.out.println(exerciseService.read(pushUps1.getId()));*/

        /*System.out.println(programService.read((long) 1));
        System.out.println(exerciseTemplateService.read((long) 1));
        System.out.println(exerciseService.read((long) 1));*/
    }

}
