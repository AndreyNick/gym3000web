package com.gym.objects;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by AndreyNick on 02.09.2014.
 */

@Entity
@Table(name = "program")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "program_id", unique = true, nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order", unique = true, nullable = false)
    private long order;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "program", cascade = CascadeType.ALL)
    private List<Workout> workoutList;

    public Program(){}

    public Program(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Workout> getWorkoutList() {
        return workoutList;
    }

    public void setWorkoutList(List<Workout> workoutList) {
        this.workoutList = workoutList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Program program = (Program) o;

        if (!description.equals(program.description)) return false;
        if (!name.equals(program.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString(){
        return String.valueOf(getId()) + " " + getName() + " " + getDescription();
    }
}
