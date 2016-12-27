package com.gym.dao.impl;

import com.gym.objects.Role;
import com.gym.objects.Set;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by AndrewNick on 23.10.2016.
 */
public class RoleDaoImpl extends GenericDaoImpl {

    protected RoleDaoImpl() {
        super(Role.class);
    }

    public List<Role> getRolesByUserId(Long userId) {
        Query query = getSession().createQuery("from Role where user.id = :userId");
        query.setParameter("userId", userId);
        List list = query.list();
        return list;

    }
}
