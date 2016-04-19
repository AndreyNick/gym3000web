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

    Long exerciseTempId1;
    Long exerciseTempId2;
    Long exerciseId1;
    Long exerciseId2;
    Long programId1;
    Long programId2;
    Long programTemplateId1;
    Long programTemplateId2;


    /**
     * ExerciseTemplate could be created without ProgramTemplate
     */
    @Test
    public void createReadExerciseTemplate() {
        exerciseTempId1 = exerciseTemplateService.create(exerciseTemplate1);
        exerciseTempId2 = exerciseTemplateService.create(exerciseTemplate2);

        ExerciseTemplate et1 = exerciseTemplateService.read(exerciseTempId1);
        ExerciseTemplate et2 = exerciseTemplateService.read(exerciseTempId2);

        Assert.assertEquals(exerciseTemplate1, et1);
        Assert.assertEquals(exerciseTemplate2, et2);
    }

    /**
     * ProgramTemplate could be created without ExerciseTemplates list
     */
    @Test
    public void createReadProgramTemplate() {
        programTemplateId1 = programTemplateService.create(programTemplate1);
        programTemplateId2 = programTemplateService.create(programTemplate2);

        ProgramTemplate pt1 = programTemplateService.read(programTemplateId1);
        ProgramTemplate pt2 = programTemplateService.read(programTemplateId2);

        Assert.assertEquals(programTemplate1, pt1);
        Assert.assertEquals(programTemplate2, pt2);
    }

    @Test
    public void createReadProgram() {
        programId1 = programService.create(program1);
        programId2 = programService.create(program2);

        Program p1 = programService.read(programId1);
        Program p2 = programService.read(programId2);

        Assert.assertEquals(program1, p1);
        Assert.assertEquals(program2, p2);

    }


    @Test
    public void createReadExercise() {
        exercise1.setExerciseTemplate(exerciseTemplate1);
        exercise2.setExerciseTemplate(exerciseTemplate2);
        exercise1.setProgram(program1);
        exercise2.setProgram(program1);
        exerciseId1 = exerciseService.create(exercise1);
        exerciseId2 = exerciseService.create(exercise2);

        Exercise e1 = exerciseService.read(exerciseId1);
        Exercise e2 = exerciseService.read(exerciseId2);


        System.out.println(e1 + "\n" + programService.read(program1.getId()));   //todo check why exercise list in program is empty

        Assert.assertEquals(exercise1, e1);
        Assert.assertEquals(exercise2, e2);
    }

}
