package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by AndreyNick on 02.09.2014.
 */

@Entity
@Table(name = "attempt")
public class Attempt {

    public Attempt(Exercise parentExercise, int weight, int times) {
        this.exercise = parentExercise;
        this.weight = weight;
        this.times = times;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "attempt_id", unique = true, nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

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
        return exercise;
    }

    public void setParentExercise(Exercise parentExercise) {
        this.exercise = parentExercise;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attempt attempt = (Attempt) o;

        if (times != attempt.times) return false;
        if (weight != attempt.weight) return false;
        if (!exercise.equals(attempt.exercise)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exercise.hashCode();
        result = 31 * result + weight;
        result = 31 * result + times;
        return result;
    }
}
