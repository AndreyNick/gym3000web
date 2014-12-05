package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by anni0913 on 27.11.2014.
 */
@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "exercise_id", unique = true, nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @Column(name = "name", nullable = false)
    private Date date;                                                                 //TODO check type

    @Column(name = "type_of_exercise")
    private String typeOfExercise;                                                    //   TODO check type

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exercise", cascade = CascadeType.ALL)
    private List<Attempt> attemptList;

    public Exercise(){}

    public Exercise(Workout parentWorkout, Date date, String typeOfExercise) {
        this.workout = parentWorkout;
        this.date = date;
        this.typeOfExercise = typeOfExercise;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTypeOfExercise() {
        return typeOfExercise;
    }

    public void setTypeOfExercise(String typeOfExercise) {
        this.typeOfExercise = typeOfExercise;
    }

    public List<Attempt> getAttemptList() {
        return attemptList;
    }

    public void setAttemptList(List<Attempt> attemptList) {
        this.attemptList = attemptList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exercise exercise = (Exercise) o;

        if (!date.equals(exercise.date)) return false;
        if (!typeOfExercise.equals(exercise.typeOfExercise)) return false;
        if (!workout.equals(exercise.workout)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workout.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + typeOfExercise.hashCode();
        return result;
    }
}
