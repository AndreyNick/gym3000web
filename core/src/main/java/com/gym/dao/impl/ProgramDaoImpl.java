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

    public List<Program> getProgramsByOwnerId(Long ownerId) {
        Query query = getSession().createQuery("from Program where owner.id = :ownerId");
        query.setParameter("ownerId", ownerId);
        List list = query.list();
        return list;
    }
}
