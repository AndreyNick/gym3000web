package com.gym.service;

import com.gym.dao.impl.ExerciseDaoImpl;
import com.gym.objects.Exercise;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for Exercise object
 */
@Service
public class ExerciseService
        extends AbstractGenericService<Exercise, Long> {

    private ExerciseDaoImpl edi;

    protected ExerciseService(ExerciseDaoImpl dao) {
        super(dao);
        edi = dao;
    }

    @Transactional(readOnly = true)
    public List<Exercise> getExercisesByProgramId(Long programId) {
        return edi.getExercisesByProgramId(programId);
    }
}
