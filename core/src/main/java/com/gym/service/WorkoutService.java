package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.ExerciseType;
import org.springframework.stereotype.Service;

/**
 * Created by anni0913 on 28.11.2014.
 */
@Service
public class WorkoutService extends AbstractGenericService<ExerciseType, Long> {

    protected WorkoutService(GenericDao<ExerciseType, Long> dao) {
        super(dao);
    }
}
