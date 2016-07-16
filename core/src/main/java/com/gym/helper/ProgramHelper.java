package com.gym.helper;

import com.gym.objects.Program;
import com.gym.service.ExerciseService;
import com.gym.service.ExerciseTemplateService;
import com.gym.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * This class helps to work with Program object
 */

public class ProgramHelper {

    @Autowired
    ProgramService programService;
    @Autowired
    ExerciseService exerciseService;
    @Autowired
    ExerciseTemplateService exerciseTemplateService;

    /*public void createProgram(Program program) {
    }*/
}
