package com.gym;

import com.gym.objects.Exercise;
import com.gym.objects.ExerciseTemplate;
import com.gym.objects.HasIdAndName;
import com.gym.service.AbstractGenericService;
import com.gym.service.ExerciseTemplateService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:temporary_test_context.xml")
public class ServiceTemplateCRUDTest extends AbstractCRUDTest {

    @Autowired
    ExerciseTemplateService exerciseTemplateService;

    @Autowired
    ExerciseTemplate exerciseTemplate;

    public void setValues() {
        setExpected(exerciseTemplate);
        //setService(exerciseTemplateService); TODO this cause error

    }

}
