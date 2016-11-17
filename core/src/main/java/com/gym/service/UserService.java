package com.gym.service;

import com.gym.dao.impl.UserDaoImpl;
import com.gym.objects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by anni0913 on 27.09.2016.
 */
public class UserService extends AbstractGenericService<User, Long> {

    private UserDaoImpl udi;

    @Autowired
    private PasswordEncoder passwordEncoder;

    protected UserService(UserDaoImpl udi) {
        super(udi);
        this.udi = udi;
    }

    @Transactional
    @Override
    public Long create(User object) {
        object.setPassword(passwordEncoder.encode(object.getPassword()));
        return dao.create(object);
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
