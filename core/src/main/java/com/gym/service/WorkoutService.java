package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.Workout;

/**
 * Created by anni0913 on 28.11.2014.
 */
public class WorkoutService extends AbstractGenericService<Workout, Long> {

    protected WorkoutService(GenericDao<Workout, Long> dao) {
        super(dao);
    }
}
