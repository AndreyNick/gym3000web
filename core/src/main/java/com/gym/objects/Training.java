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
}
