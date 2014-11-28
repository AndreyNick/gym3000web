package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.Program;

/**
 * Created by anni0913 on 28.11.2014.
 */
public class ProgramService extends AbstractGenericService<Program, Long> {

    protected ProgramService(GenericDao<Program, Long> dao) {
        super(dao);
    }
}
