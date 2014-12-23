package com.gym.stub;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by anni0913 on 23.12.2014.
 */
public class ProgramDAO {

    private List<Program> store = new LinkedList<Program>();


    public ProgramDAO(){
        store.add(new Program("Program1", "Description1"));
        store.add(new Program("Program2", "Description2"));
    }

    public void create(Program program){
        store.add(program);
    }

    public Program getProgramByIndex(int index){
        return store.get(index);
    }

    public List<Program> getAll(){
        return store;
    }
}
