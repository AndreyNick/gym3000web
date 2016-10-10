package com.gym;

import com.gym.objects.User;
import com.gym.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:temporary_test_context.xml")
public class TemporaryTest {



    @Autowired
    User user1;
    @Autowired
    UserService userService;



    @Test
    public void test() {
        userService.create(user1);

    }
}
