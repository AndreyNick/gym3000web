package com.gym.objects;

import com.gym.service.AttemptService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by anni0913 on 08.12.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test_config.xml")
public class AttemptServiceTest extends AbstractServiceTest{

    @Autowired
    AttemptService attemptService;

    @Autowired
    Attempt testAttempt;

    @Override
    @Test
    @Ignore
    public void crudTest() {

    }

    @Override
    @Test
    @Ignore
    public void readAllTest() {

    }
}
