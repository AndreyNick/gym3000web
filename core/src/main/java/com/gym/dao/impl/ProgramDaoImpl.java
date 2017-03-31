package com.gym.dao.impl;

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

    public List<Program> getProgramsByText(String text) {
        Query query = getSession().createQuery("from Program where user.name in :text");
        query.setParameter("text", text);
        List list = query.list();
        return list;
    }
}
