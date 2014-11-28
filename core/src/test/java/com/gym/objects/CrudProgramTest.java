package com.gym.objects;

import com.gym.service.ProgramService;
import com.gym.objects.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;

/**
 * Created by anni0913 on 28.11.2014.
 */
public class CrudProgramTest extends CrudGenericTest<Program, Long>{

    /*public CrudProgramTest() {
        setTestObject(program);
    }*/

    @Autowired
    ProgramService programService;

   /* @Autowired
    Program program;*/

    @Autowired
    public void setUser(Program program){
        setTestObject(program);
    }


    @Override
    public Long create(Program object) {
        return programService.create(object);
    }

    @Override
    public Program read(Long id) {
        return programService.read(/*program.getId()*/ Long.parseLong("1"));
    }
}

