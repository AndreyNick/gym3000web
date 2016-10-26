package com.gym;

import com.gym.objects.Role;
import com.gym.objects.User;
import com.gym.service.RoleService;
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

    @Autowired
    RoleService roleService;



    @Test
    public void test() {
        userService.create(user1);
        Role r = new Role(user1, Role.USER);
        roleService.create(r);
        Role r1 = new Role(user1, Role.ADMIN);
        roleService.create(r1);
    }
}
