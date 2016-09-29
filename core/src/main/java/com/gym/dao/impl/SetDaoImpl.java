package com.gym.dao.impl;

import com.gym.objects.Set;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by anni0913 on 29.09.2016.
 */
public class SetDaoImpl extends GenericDaoImpl {

    protected SetDaoImpl() {
        super(Set.class);
    }

    public List<Set> getSetsByExerciseId(Long exerciseId) {
        Query query = getSession().createQuery("from Set where exercise.id = :exerciseId");
        query.setParameter("exerciseId", exerciseId);
        List list = query.list();
        return list;
    }
}
