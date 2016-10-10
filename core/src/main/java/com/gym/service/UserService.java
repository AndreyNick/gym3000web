package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.User;

/**
 * Created by anni0913 on 27.09.2016.
 */
public class UserService extends AbstractGenericService<User, Long> {

    protected UserService(GenericDao<User, Long> dao) {
        super(dao);
    }
}
