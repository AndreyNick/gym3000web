package com.gym.objects;

import javax.persistence.*;
import java.util.List;

/**
 * This class keeps ExerciseType list. It can be called like 'ExerciseType group'.
 * Program shows list of the exercise names which you should do during training
 */


@Entity
@Table(name = "program")
public class Program {


    private Long id;

    private String name;

    private String description;

    private String notes;

    private int orderNumber;

    private List<ExerciseType> exerciseTypeList;


}
