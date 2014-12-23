package com.gym.stub;

import java.util.List;

/**
 * Created by anni0913 on 23.12.2014.
 */
public class ProgramService {

    private ProgramDAO dao;

    public ProgramService(ProgramDAO dao){
        this.dao = dao;
    }
    public void create(Program program){
        dao.create(program);
    }

    public Program getProgramByIndex(int index){
        return dao.getProgramByIndex(index);
    }

    public List<Program> getAll(){
        return dao.getAll();
    }
}
