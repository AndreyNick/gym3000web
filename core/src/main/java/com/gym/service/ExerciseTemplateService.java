package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.Exercise;
import com.gym.objects.ExerciseTemplate;
import org.springframework.stereotype.Service;

/**
 * Service for ExerciseTemplate object
 */
@Service
public class ExerciseTemplateService
        extends AbstractGenericService<ExerciseTemplate, Long> {

    protected ExerciseTemplateService(GenericDao<ExerciseTemplate, Long> dao) {
        super(dao);}
}
