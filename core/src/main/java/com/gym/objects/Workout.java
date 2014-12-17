package com.gym.objects;

import javax.persistence.*;
import java.util.List;

/**
 * Created by AndreyNick on 02.09.2014.
 */
@Entity
@Table(name = "workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "workout_id", unique = true, nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "picture_id")
    private int picture_id;

/*    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order", unique = true, nullable = false)
    private long order;*/

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workout", cascade = CascadeType.ALL)
    private List<Exercise> exerciseList;

    public Workout(){}

    public Workout(Program parentProgram, String name, String description, int picture_id) {
        this.program = parentProgram;
        this.name = name;
        this.description = description;
        this.picture_id = picture_id;
    }

/*    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
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

    public int getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(int picture_id) {
        this.picture_id = picture_id;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Workout workout = (Workout) o;

        if (picture_id != workout.picture_id) return false;
        if (!description.equals(workout.description)) return false;
        if (!name.equals(workout.name)) return false;
        if (!program.equals(workout.program)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = program.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + picture_id;
        return result;
    }
}
