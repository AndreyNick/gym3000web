package com.gym.objects;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by AndreyNick on 02.09.2014.
 */

@Entity
@Table(name = "program")

public class Program implements HasNameAndDescription{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "program_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "order_number", unique = true, nullable = false)
    private int orderNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "program", cascade = CascadeType.ALL)
    @OrderBy("order_number")
    private List<Workout> workoutList;

    public Program(){}

    public Program(String name, String description, int orderNumber) {
        this.name = name;
        this.description = description;
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
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
