package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.Exercise;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Service for Exercise object
 */
@Service
public class ExerciseService
        extends AbstractGenericService<Exercise, Long> {

    protected ExerciseService(GenericDao<Exercise, Long> dao) {
        super(dao);
    }
}
