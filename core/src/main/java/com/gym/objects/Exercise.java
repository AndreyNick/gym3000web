package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


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

    @Column(name = "description")
    private String description;

    @Column(name = "note")
    private String note;

    public Exercise() {
    }

    public Exercise(Program program, ExerciseTemplate exerciseTemplate, String name, String description, String note) {
        this.program = program;
        this.exerciseTemplate = exerciseTemplate;
        this.name = name;
        this.description = description;
        this.note = note;
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
        if (!(o instanceof Exercise)) return false;

        Exercise exercise = (Exercise) o;

        if (description != null ? !description.equals(exercise.description) : exercise.description != null)
            return false;
        if (!exerciseTemplate.equals(exercise.exerciseTemplate)) return false;
        if (!name.equals(exercise.name)) return false;
        if (note != null ? !note.equals(exercise.note) : exercise.note != null) return false;
        if (!program.equals(exercise.program)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = program.hashCode();
        result = 31 * result + exerciseTemplate.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\nExercise{id=" + id + ", name='" + name +
                ", \n\tProgram='[{id=" + program.getId() + ", name='" + program.getName() + "']'" +
                ", \n\tExerciseTemplate='[{id=" + exerciseTemplate.getId() + ", name='" + exerciseTemplate.getName() + "']'" +
                '}';
    }
}
