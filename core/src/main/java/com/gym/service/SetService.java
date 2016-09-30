package com.gym.service;

import com.gym.dao.impl.SetDaoImpl;
import com.gym.objects.Set;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by anni0913 on 29.09.2016.
 */
public class SetService extends AbstractGenericService<Set, Long> {

    private SetDaoImpl sdi;

    protected SetService(SetDaoImpl sdi) {
        super(sdi);
        this.sdi = sdi;
    }

    @Transactional
    public List<Set> getSetsByExerciseId(Long exerciseId) {
        return sdi.getSetsByExerciseId(exerciseId);
    }
}
