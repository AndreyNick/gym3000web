package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedList;
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

    @Column(name = "date", nullable = false)
    private Date date;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "program")
    private List<Exercise> exerciseList = new LinkedList<Exercise>();

    public Program() {
    }


    public Program(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        if (!(o instanceof Program)) return false;

        Program program = (Program) o;

        if (!date.equals(program.date)) return false;
        if (exerciseList != null ? !exerciseList.equals(program.exerciseList) : program.exerciseList != null)
            return false;
        if (!name.equals(program.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + (exerciseList != null ? exerciseList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String exercises = "";
        for(Exercise item : exerciseList) {
            exercises += "{id=" + item.getId() + ", name='" + item.getName() + "\'}";
        }
        return "Program{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", exerciseList=[" + exercises + ']' +
                '}';
    }
}
