package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.Program;
import org.springframework.stereotype.Service;

/**
 * Created by anni0913 on 28.11.2014.
 */
@Service
public class ProgramService extends AbstractGenericService<Program, Long> {

    protected ProgramService(GenericDao<Program, Long> dao) {
        super(dao);
    }
}
