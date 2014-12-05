package com.gym.objects;

import com.gym.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by anni0913 on 28.11.2014.
 */
public class ProgramCrudTest extends CrudGenericTest<Program, Long>{

    @Autowired
    ProgramService programService;

    @Autowired
    private void setInsObject(Program program){
        setTestObject(program);
    }


    @Override
    public Long create(Program object) {
        return programService.create(object);
    }

    @Override
    public Program read(Long id) {
        return programService.read(id);
    }

    @Override
    public void update(Program object) {
        programService.update(object);
    }

    @Override
    public void delete(Program object) {
        programService.delete(object);
    }

    @Override
    public List<Program> readAll() {
        return programService.readAll();
    }
}

