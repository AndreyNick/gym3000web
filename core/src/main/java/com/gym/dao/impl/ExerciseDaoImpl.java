package com.gym.dao.impl;

import com.gym.objects.Exercise;
import org.hibernate.Query;

import java.util.List;

public class ExerciseDaoImpl extends GenericDaoImpl {

    protected ExerciseDaoImpl() {
        super(Exercise.class);
    }

    public List<Exercise> getExercisesByProgramId(Long programId) {
        Query query = getSession().createQuery("from Exercise where program.id = :programId");
        query.setParameter("programId", programId);
        List list = query.list();
        return list;
    }
}
