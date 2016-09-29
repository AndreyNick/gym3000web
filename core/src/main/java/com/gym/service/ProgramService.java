package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.dao.impl.ProgramDaoImpl;
import com.gym.objects.Exercise;
import com.gym.objects.Program;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for Program object
 */
@Service
public class ProgramService
        extends AbstractGenericService<Program, Long> {

    private ProgramDaoImpl pdi;

    protected ProgramService(ProgramDaoImpl pdi) {
        super(pdi);
        this.pdi = pdi;
    }

    @Transactional
    public List<Program> getProgramsByOwnerId(Long ownerId) {
        return pdi.getProgramsByOwnerId(ownerId);
    }
}
