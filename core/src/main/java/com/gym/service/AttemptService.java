package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.Attempt;

/**
 * Created by anni0913 on 28.11.2014.
 */
public class AttemptService extends AbstractGenericService<Attempt, Long> {

    protected AttemptService(GenericDao<Attempt, Long> dao) {
        super(dao);
    }
}
