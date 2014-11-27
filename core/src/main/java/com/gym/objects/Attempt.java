package com.gym.objects;

import javax.persistence.*;

/**
 * Created by AndreyNick on 02.09.2014.
 */

@Entity
@Table(name = "attempt")
public class Attempt {

    public Attempt(Exercise parentExercise, int weight, int times) {
        this.parentExercise = parentExercise;
        this.weight = weight;
        this.times = times;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attempt_id", unique = true, nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise parentExercise;

    @Column(name = "weight", nullable = false)
    private int weight;

    @Column(name = "times", nullable = false)
    private int times;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Exercise getParentExercise() {
        return parentExercise;
    }

    public void setParentExercise(Exercise parentExercise) {
        this.parentExercise = parentExercise;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
