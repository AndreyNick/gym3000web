package com.gym.dao.impl;

import com.gym.objects.Exercise;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The extension of GenericDaoImpl. It contains extra method that regular CRUD couldn't contain
 */

@Repository
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
