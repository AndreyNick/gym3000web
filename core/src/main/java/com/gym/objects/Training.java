package com.gym.objects;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * This class shows some training day. It keeps records about date of training, all exercises that you
 * did and some additional info
 */

public class Training {

    public enum TrainingStatus{
        PLANNED,
        IN_PROGRESS,
        FINISHED
    }

    private Long id;

    private Owner owner;

    private Date date;

    private TrainingStatus status;

    private Double ownerWeight;

    private Time startTrainingTime;

    private Time endTrainingTime;

    private String notes;

    private List<Exercise> exercisesList;
}
