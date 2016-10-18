package com.gym.dao.impl;

import com.gym.objects.User;
import org.hibernate.Query;

import java.util.List;

public class UserDaoImpl extends GenericDaoImpl {

    protected UserDaoImpl() {
        super(User.class);
    }

    public User readByName(String name) {
        Query query = getSession().createQuery("from User where name = :name");
        query.setParameter("name", name);
        List<User> userList = query.list();
        return userList.iterator().next();
    }
}
