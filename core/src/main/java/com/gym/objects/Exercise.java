package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.sql.Date;
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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "type_of_exercise")
    private String type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exercise", cascade = CascadeType.ALL)
    private List<Attempt> attemptList;

    public Exercise(){}

    public Exercise(Workout parentWorkout, Date date, String type) {
        this.workout = parentWorkout;
        this.date = date;
        this.type = type;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!type.equals(exercise.type)) return false;
        if (!workout.equals(exercise.workout)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workout.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
