package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.Exercise;
import com.gym.objects.Training;

/**
 * Created by anni0913 on 25.02.2015.
 */
public class TrainingService extends AbstractGenericService<Training, Long> {

    protected TrainingService(GenericDao<Training, Long> dao) {
        super(dao);
    }
}
