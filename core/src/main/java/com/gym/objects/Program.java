package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * This class keeps ExerciseType list. It can be called like 'ExerciseType group'.
 * Program shows list of the exercise names which you should do during training
 */

@Entity
@Table(name = "program")
public class Program {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "program_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "note")
    private String note;

    @Column(name = "order_number")
    private int orderNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "program", cascade = CascadeType.ALL)
    private List<ExerciseType> exerciseTypeList;

    public Program(String name, String description, String note, int orderNumber) {
        this.name = name;
        this.description = description;
        this.note = note;
        this.orderNumber = orderNumber;
    }

    public Program() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<ExerciseType> getExerciseTypeList() {
        return exerciseTypeList;
    }

    public void setExerciseTypeList(List<ExerciseType> exerciseTypeList) {
        this.exerciseTypeList = exerciseTypeList;
    }
}
