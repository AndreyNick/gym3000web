package com.gym.objects;

import java.util.Collection;

/**
 * Created by AndreyNick on 02.09.2014.
 */
public class Workout {

    public Workout(){}

    public Workout(boolean isWarmingWorkout, String workoutName, String workoutDescription, Collection<Set> setsCollection) {
        this.isWarmingWorkout = isWarmingWorkout;
        this.workoutName = workoutName;
        this.workoutDescription = workoutDescription;
        this.setsCollection = setsCollection;
    }

    boolean isWarmingWorkout; //TODO realise posibility of warming
    String workoutName;
    String workoutDescription;
    Collection<Set> setsCollection;

    public boolean isWarmingWorkout() {
        return isWarmingWorkout;
    }

    public void setWarmingWorkout(boolean isWarmingWorkout) {
        this.isWarmingWorkout = isWarmingWorkout;
    }

    public String getWorkoutDescription() {
        return workoutDescription;
    }

    public void setWorkoutDescription(String workoutDescription) {
        this.workoutDescription = workoutDescription;
    }

    public Collection<Set> getSetsCollection() {
        return setsCollection;
    }

    public void setSetsCollection(Collection<Set> setsCollection) {
        this.setsCollection = setsCollection;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }
}
