package com.gym.objects;

import com.gym.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by anni0913 on 28.11.2014.
 */
public class CrudProgramTest<T> extends CrudGenericTest<T>{

    @Autowired
    ProgramService programService;

    @Autowired
    Program program;

    @Override
    public Long create(T object) {
        return programService.create(program);
    }

    @Override
    public T read(Long id) {
        return programService.read(program.getId());
    }
}
