package com.gym.objects;

import java.util.Collection;

/**
 * Created by AndreyNick on 02.09.2014.
 */
public class Program {

    public Program(String programName, String programDescription, Collection<Workout> workoutsCollection) {
        this.programName = programName;
        this.programDescription = programDescription;
        this.workoutsCollection = workoutsCollection;
    }
    public Program(){}

    String programName;
    String programDescription;
    Collection<Workout> workoutsCollection;

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public Collection<Workout> getWorkoutsCollection() {
        return workoutsCollection;
    }

    public void setWorkoutsCollection(Collection<Workout> workoutsCollection) {
        this.workoutsCollection = workoutsCollection;
    }
}
