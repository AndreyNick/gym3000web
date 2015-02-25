package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * This class shows exercise type, for example push-ups or triceps exercise.
 */

public class ExerciseType {

    private Long id;

    private Program program;

    private String name;

    private String description;

    private String notes;

    private int picture_id;

    private int orderNumber;

    private List<Exercise> exerciseList;


}
