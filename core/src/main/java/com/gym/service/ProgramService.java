package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.Exercise;
import com.gym.objects.Program;
import org.springframework.stereotype.Service;

/**
 * Service for Program object
 */
@Service
public class ProgramService
        extends AbstractGenericService<Program, Long> {

    protected ProgramService(GenericDao<Program, Long> dao) {
        super(dao);
    }
}
