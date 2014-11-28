package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.Exercise;

/**
 * Created by anni0913 on 28.11.2014.
 */
public class ExerciseService extends AbstractGenericService<Exercise, Long> {

    protected ExerciseService(GenericDao<Exercise, Long> dao) {
        super(dao);
    }
}
