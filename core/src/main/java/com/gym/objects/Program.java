package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * This class keeps Exercises list. It can be called like 'Exercises group'.
 * Program shows list of the exercise names which you should do during training.
 * It also contains the date of training.
 */

@Entity
@Table(name = "program")
public class Program implements HasIdAndName{

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "program_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    //@DateTimeFormat(pattern = "dd.MM.yy")
    @Column(name = "date", nullable = false)
    private Date date;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "program")
    private List<Exercise> exerciseList = new LinkedList<Exercise>();

    @Column(name = "description")
    private String description;

    @Column(name = "note")
    private String note;

    public Program() {
    }

    public Program(String name, Date date, String description, String note) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.note = note;
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

    public void addExercise(Exercise exercise) {
        exerciseList.add(exercise);
    }

    public void deleteExercise(Exercise exercise) {
        exerciseList.remove(exercise);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Program)) return false;

        Program program = (Program) o;

        if (!date.equals(program.date)) return false;
        if (description != null ? !description.equals(program.description) : program.description != null) return false;
        if (exerciseList != null ? !exerciseList.equals(program.exerciseList) : program.exerciseList != null)
            return false;
        if (!name.equals(program.name)) return false;
        if (note != null ? !note.equals(program.note) : program.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + (exerciseList != null ? exerciseList.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String exercises = "";
        for(Exercise item : exerciseList) {
            exercises += "\n\t\t{id=" + item.getId() + ", name='" + item.getName() + "\'}";
        }
        return "\nProgram{id=" + id + ", name='" + name +
                "', \n\texerciseList=[" + exercises + ']' +
                '}';
    }
}
