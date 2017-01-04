package com.gym.service;

import com.gym.dao.impl.ProgramDaoImpl;
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
    public List<Program> getProgramsByUserId(Long userId) {
        return pdi.getProgramsByUserId(userId);
    }

    @Transactional
    public List<Program> getProgramsByText(String text) {
        return pdi.getProgramsByText(text);
    }

}
