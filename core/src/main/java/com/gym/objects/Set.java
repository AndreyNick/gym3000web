package com.gym.objects;

/**
 * Created by AndreyNick on 02.09.2014.
 */
public class Set {

    public Set() {}

    public Set(boolean isWarmingSet, int weight, int numberOfTimes) {
        this.isWarmingSet = isWarmingSet;
        this.weight = weight;
        this.numberOfTimes = numberOfTimes;
    }

    boolean isWarmingSet;
    int weight;
    int numberOfTimes;

    public boolean isWarmingSet() {
        return isWarmingSet;
    }

    public void setWarmingSet(boolean isWarmingSet) {
        this.isWarmingSet = isWarmingSet;
    }

    public int getNumberOfTimes() {
        return numberOfTimes;
    }

    public void setNumberOfTimes(int numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
