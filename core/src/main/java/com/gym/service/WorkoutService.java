package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.Workout;
import org.springframework.stereotype.Service;

/**
 * Created by anni0913 on 28.11.2014.
 */
@Service
public class WorkoutService extends AbstractGenericService<Workout, Long> {

    protected WorkoutService(GenericDao<Workout, Long> dao) {
        super(dao);
    }
}
