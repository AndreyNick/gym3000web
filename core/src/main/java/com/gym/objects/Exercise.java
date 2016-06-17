package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name = "exercise")
public class Exercise implements HasIdAndName {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "exercise_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_template_id", nullable = false)
    private ExerciseTemplate exerciseTemplate;

    @Column(name = "name")
    private String name;

    public Exercise() {
    }

    public Exercise(Program program, ExerciseTemplate exerciseTemplate, String name) {
        this.program = program;
        this.exerciseTemplate = exerciseTemplate;
        this.name = name;
    }

    public Exercise(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public ExerciseTemplate getExerciseTemplate() {
        return exerciseTemplate;
    }

    public void setExerciseTemplate(ExerciseTemplate exerciseTemplate) {
        this.exerciseTemplate = exerciseTemplate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exercise)) return false;

        Exercise exercise = (Exercise) o;

        if (exerciseTemplate != null ? !exerciseTemplate.equals(exercise.exerciseTemplate) : exercise.exerciseTemplate != null)
            return false;
        if (!name.equals(exercise.name)) return false;
        if (!program.equals(exercise.program)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = program.hashCode();
        result = 31 * result + (exerciseTemplate != null ? exerciseTemplate.hashCode() : 0);
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Program='[{id=" + program.getId() + ", name='" + program.getName() + "']'" +
                '}';
    }
}
