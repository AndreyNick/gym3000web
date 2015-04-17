package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by AndreyNick on 02.09.2014.
 */

@Entity
@Table(name = "attempt")
public class Attempt{

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "attempt_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;


    /**
     * This field shows what weight you did in your attempt
     */
    @Column(name = "actual_weight")
    private Double actualWeight;

    /**
     * This field shows what weight you should to do in your attempt
     * in case you write plan before training
     */
    @Column(name = "estimate_weight")
    private Double estimateWeight;

    /**
     * This field shows how many times you did in your attempt
     */
    @Column(name = "actual_times")
    private int actualTimes;

    /**
     * This field shows how many times you should do in your attempt
     * in case you write plan before training
     */
    @Column(name = "estimate_times")
    private int estimateTimes;

    @Column(name = "note")
    private String note;

    public Attempt(Exercise exercise, Double actualWeight, Double estimateWeight, int actualTimes, int estimateTimes, String note) {
        this.exercise = exercise;
        this.actualWeight = actualWeight;
        this.estimateWeight = estimateWeight;
        this.actualTimes = actualTimes;
        this.estimateTimes = estimateTimes;
        this.note = note;
    }

    public Attempt() {
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Double getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(Double actualWeight) {
        this.actualWeight = actualWeight;
    }

    public Double getEstimateWeight() {
        return estimateWeight;
    }

    public void setEstimateWeight(Double estimateWeight) {
        this.estimateWeight = estimateWeight;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getEstimateTimes() {
        return estimateTimes;
    }

    public void setEstimateTimes(int estimateTimes) {
        this.estimateTimes = estimateTimes;
    }

    public int getActualTimes() {
        return actualTimes;
    }

    public void setActualTimes(int actualTimes) {
        this.actualTimes = actualTimes;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString(){
        return "Attempt id = " + id + ", exercise id = " + exercise.getId() +
                ", estimateWeight: " + estimateWeight + " actualWeight: " + actualWeight + ", estimateTimes: "
                + estimateTimes + ", actualTimes: " + actualTimes;
    }
}
