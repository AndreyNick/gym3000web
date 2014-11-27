package com.gym.objects;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by anni0913 on 27.11.2014.
 */
@Entity
@Table(name = "exercise")
public class Exercise {

    public Exercise(Workout parentWorkout, Date date, String typeOfExercise) {
        this.parentWorkout = parentWorkout;
        this.date = date;
        this.typeOfExercise = typeOfExercise;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "workout_id", unique = true, nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout parentWorkout;

    @Column(name = "name", nullable = false)
    private Date date;                                                                 //TODO check type

    @Column(name = "name")
    private String typeOfExercise;                                                    //   TODO check type

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exercise", cascade = CascadeType.ALL)
    private List<Attempt> attemptList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Workout getParentWorkout() {
        return parentWorkout;
    }

    public void setParentWorkout(Workout parentWorkout) {
        this.parentWorkout = parentWorkout;
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
}
