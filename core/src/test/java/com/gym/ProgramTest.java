package com.gym;

import com.gym.objects.Exercise;
import com.gym.objects.ExerciseTemplate;
import com.gym.objects.Program;
import com.gym.service.ProgramService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

/**
 * Test class for ProgramService
 */
public class ProgramTest extends GenericTest{

    @Autowired
    ProgramService programService;
    @Autowired
    Program program1;
    @Autowired
    Program program2;
    @Autowired
    Program equalProgram1;
    @Autowired
    Program equalProgram2;



    @Override
    public void init() {
        setExpected(program1);
        setService(programService);
    }
}
