package com.gym.stub;



/**
 * Created by AndreyNick on 02.09.2014.
 */


public class Program {


    private String name;

    private String description;



    public Program(){}

    public Program(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Program program = (Program) o;

        if (!description.equals(program.description)) return false;
        if (!name.equals(program.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString(){
        return getName() + " " + getDescription();
    }
}
