package com.gym;

import com.gym.objects.User;
import com.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public class UserTest extends GenericTest {

    @Autowired
    UserService userService;

    @Autowired
    User user1;

    @Autowired
    User user2;

    @Override
    public void init() {
        setExpected(user1);
        setService(userService);
    }
}
