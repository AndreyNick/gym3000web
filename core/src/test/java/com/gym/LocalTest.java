package com.gym;

import com.gym.objects.ExerciseTemplate;
import com.gym.objects.ProgramTemplate;
import com.gym.service.ExerciseTemplateService;
import com.gym.service.ProgramTemplateService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:local_test_context.xml")
public class LocalTest {

    @Autowired
    ProgramTemplateService programTemplateService;

    @Autowired
    ExerciseTemplateService templateService;

    @org.junit.Test
    public void test() {
        ExerciseTemplate exerciseTemplate1 = new ExerciseTemplate("exerciseTemplate1");
        ExerciseTemplate exerciseTemplate2 = new ExerciseTemplate("exerciseTemplate2");
        List<ExerciseTemplate> list = new LinkedList<ExerciseTemplate>();
        list.add(exerciseTemplate1);
        list.add(exerciseTemplate2);
        ProgramTemplate programTemplate = new ProgramTemplate("programTemplate", list);

        programTemplateService.create(programTemplate);

    }


}
