package com.gym.objects;

/**
 * Created by AndreyNick on 02.09.2014.
 */
public class Result {

    public Result(int weight, int numberOfTimes) {
        this.weight = weight;
        this.numberOfTimes = numberOfTimes;
    }

    public Result() {}

    int weight;
    int numberOfTimes;

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
