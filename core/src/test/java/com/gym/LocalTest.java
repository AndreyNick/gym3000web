package com.gym;

import com.gym.objects.ExerciseTemplate;
import com.gym.objects.ProgramTemplate;
import com.gym.service.ExerciseTemplateService;
import com.gym.service.ProgramTemplateService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:local_test_context.xml")
public class LocalTest {

    @Autowired
    ProgramTemplateService programTemplateService;

    @Autowired
    ExerciseTemplateService exerciseTemplateService;

    @Autowired
    ExerciseTemplate exerciseTemplate1;

    @Autowired
    ExerciseTemplate exerciseTemplate2;

    @Autowired
    ProgramTemplate programTemplate1;

    @Autowired
    ProgramTemplate programTemplate2;

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


        ProgramTemplate pt = programTemplateService.read(new Long(1));



        System.out.println(pt);






    }


}
