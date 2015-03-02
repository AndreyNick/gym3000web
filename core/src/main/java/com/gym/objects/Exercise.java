package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.List;

/**
 * Created by anni0913 on 27.11.2014.
 */
@Entity
@Table(name = "exercise")
public class Exercise {

    public enum ExerciseLoad {
        SMALL,
        MIDDLE,
        LARGE
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "exercise_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_type_id", nullable = false)
    private ExerciseType exerciseType;

    @Column(name = "exercise_load")
    private ExerciseLoad exerciseLoad;

    @Column(name = "note")
    private String note;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exercise", cascade = CascadeType.ALL)
    private List<Attempt> attemptList;

    public Exercise(Training training, ExerciseType exerciseType, ExerciseLoad exerciseLoad, String note) {
        this.training = training;
        this.exerciseType = exerciseType;
        this.exerciseLoad = exerciseLoad;
        this.note = note;
    }

    public Exercise() {
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

    public ExerciseLoad getExerciseLoad() {
        return exerciseLoad;
    }

    public void setExerciseLoad(ExerciseLoad exerciseLoad) {
        this.exerciseLoad = exerciseLoad;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Attempt> getAttemptList() {
        return attemptList;
    }

    public void setAttemptList(List<Attempt> attemptList) {
        this.attemptList = attemptList;
    }
}
