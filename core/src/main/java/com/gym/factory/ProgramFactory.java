package com.gym.factory;

import com.gym.objects.*;
import com.gym.service.ExerciseService;
import com.gym.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

public class ProgramFactory {

    @Autowired
    ProgramService programService;

    @Autowired
    ExerciseService exerciseService;

    //todo: decide how to name programs
    public void createProgram(ProgramTemplate programTemplate, Owner owner) {
        Program newProgram = new Program(owner,
                programTemplate.getName(),
                new Date(System.currentTimeMillis()),
                programTemplate.getDescription(),
                programTemplate.getNote());
        programService.create(newProgram);
        List<ExerciseTemplate> exerciseTemplateList = programTemplate.getExerciseTemplateList();
        for(ExerciseTemplate exerciseTemplate:exerciseTemplateList) {
            exerciseService.create(new Exercise(newProgram,
                    exerciseTemplate,
                    exerciseTemplate.getName(),
                    exerciseTemplate.getDescription(),
                    exerciseTemplate.getNote()));
        }
    }
}
