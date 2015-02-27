package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * This class shows some training day. It keeps records about date of training, all exercises that you
 * did and some additional info
 */

@Entity
@Table(name = "training")
public class Training {

    public enum TrainingStatus{
        PLANNED,
        IN_PROGRESS,
        FINISHED
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "training_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "status", nullable = false)
    private TrainingStatus status;

    @Column(name = "user_weight", nullable = false)
    private Double userWeight;

    @Column(name = "start_training_time", nullable = false)
    private Time startTrainingTime;

    @Column(name = "end_training_time", nullable = false)
    private Time endTrainingTime;

    @Column(name = "note", nullable = false)
    private String note;

    @Column(name = "summary_training_weight", nullable = false)
    private Double summaryTrainingWeight;

    //private List<Exercise> exercisesList;


    public Training(Owner owner, Date date, TrainingStatus status, Double userWeight, Time startTrainingTime, Time endTrainingTime, String note, Double summaryTrainingWeight) {
        this.owner = owner;
        this.date = date;
        this.status = status;
        this.userWeight = userWeight;
        this.startTrainingTime = startTrainingTime;
        this.endTrainingTime = endTrainingTime;
        this.note = note;
        this.summaryTrainingWeight = summaryTrainingWeight;
    }

    public Training() {
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TrainingStatus getStatus() {
        return status;
    }

    public void setStatus(TrainingStatus status) {
        this.status = status;
    }

    public Double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(Double userWeight) {
        this.userWeight = userWeight;
    }

    public Time getStartTrainingTime() {
        return startTrainingTime;
    }

    public void setStartTrainingTime(Time startTrainingTime) {
        this.startTrainingTime = startTrainingTime;
    }

    public Time getEndTrainingTime() {
        return endTrainingTime;
    }

    public void setEndTrainingTime(Time endTrainingTime) {
        this.endTrainingTime = endTrainingTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getSummaryTrainingWeight() {
        return summaryTrainingWeight;
    }

    public void setSummaryTrainingWeight(Double summaryTrainingWeight) {
        this.summaryTrainingWeight = summaryTrainingWeight;
    }
}
