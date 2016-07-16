package com.gym;

import com.gym.objects.*;
import com.gym.service.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test class for ExerciseTemplateService
 */
public class ExerciseTemplateTest extends GenericTest {

    @Autowired
    ExerciseTemplateService exerciseTemplateService;
    @Autowired
    ExerciseTemplate exerciseTemplate1;

    @Override
    public void init() {
        setExpected(exerciseTemplate1);
        setService(exerciseTemplateService);
    }
}


