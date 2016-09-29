package com.gym.objects;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by anni0913 on 29.09.2016.
 */
@Entity
@Table(name = "set")
public class Set {

    public enum Measure {
        KG,
        POUND
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "set_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(name = "times")
    private int times;

    @Column(name = "weight")
    private int weight;

    @Column(name = "measure")
    private Measure measure;

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Set set = (Set) o;

        if (times != set.times) return false;
        if (weight != set.weight) return false;
        if (!exercise.equals(set.exercise)) return false;
        return measure == set.measure;

    }

    @Override
    public int hashCode() {
        int result = exercise.hashCode();
        result = 31 * result + times;
        result = 31 * result + weight;
        result = 31 * result + (measure != null ? measure.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Set{" +
                "exercise=" + exercise +
                ", times=" + times +
                ", weight=" + weight +
                ", measure=" + measure +
                '}';
    }
}
