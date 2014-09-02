package com.gym.objects;

import java.util.Collection;

/**
 * Created by AndreyNick on 02.09.2014.
 */
public class Workout {

    public Workout(String workoutName, String workoutDescription, Collection<Workout> resultsCollection) {
        this.workoutName = workoutName;
        this.workoutDescription = workoutDescription;
        this.resultsCollection = resultsCollection;
    }
    public Workout(){}

    String workoutName;
    String workoutDescription;
    Collection<Workout> resultsCollection;

    public String getWorkoutDescription() {
        return workoutDescription;
    }

    public void setWorkoutDescription(String workoutDescription) {
        this.workoutDescription = workoutDescription;
    }

    public Collection<Workout> getResultsCollection() {
        return resultsCollection;
    }

    public void setResultsCollection(Collection<Workout> resultsCollection) {
        this.resultsCollection = resultsCollection;
    }


    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }
}
