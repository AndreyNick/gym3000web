package com.gym.service;

import com.gym.dao.impl.UserDaoImpl;
import com.gym.objects.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by anni0913 on 27.09.2016.
 */
public class UserService extends AbstractGenericService<User, Long> {

    private UserDaoImpl udi;

    protected UserService(UserDaoImpl udi) {
        super(udi);
        this.udi = udi;
    }

    @Transactional
    public User readByName(String name) {
        User user = udi.readByName(name);
        return user;
    }

    @Transactional
    public User readByLogin(String login) {
        User user = udi.readByLogin(login);
        return user;
    }
}
