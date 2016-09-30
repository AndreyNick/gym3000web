package com.gym.dao.impl;

import com.gym.objects.Exercise;
import com.gym.objects.Program;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by anni0913 on 27.09.2016.
 */
public class ProgramDaoImpl extends GenericDaoImpl {

    protected ProgramDaoImpl() {
        super(Program.class);
    }

    public List<Program> getProgramsByUserId(Long userId) {
        Query query = getSession().createQuery("from Program where user.id = :userId");
        query.setParameter("userId", userId);
        List list = query.list();
        return list;
    }
}
