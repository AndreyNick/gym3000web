package com.gym.dao.impl;

import com.gym.objects.Exercise;

import java.util.LinkedList;
import java.util.List;

public class ExerciseDaoImpl extends GenericDaoImpl {

    protected ExerciseDaoImpl() {
        super(Exercise.class);
    }

    public List<Exercise> getExercisesByProgramId(Long programId) {
        List<Exercise> exerciseList = new LinkedList<>();
        return exerciseList;
    }

}
