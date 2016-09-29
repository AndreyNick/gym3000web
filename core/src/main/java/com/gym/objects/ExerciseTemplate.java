package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


/**
 * This class provides templates of exercises. Exercise objects are created by ExerciseTemplate.
 * We can create a lot of Exercises from one template.
 */
@Entity
@Table(name = "exercise_template")
public class ExerciseTemplate implements HasIdAndName {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "exercise_template_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy="exerciseTemplateList")
    private List<ProgramTemplate> programTemplateList = new LinkedList<ProgramTemplate>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exerciseTemplate")
    private List<Exercise> exerciseList = new LinkedList<Exercise>();

    @Column(name = "description")
    private String description;

    @Column(name = "note")
    private String note;

    public ExerciseTemplate() {
    }

    public ExerciseTemplate(String name, String description, String note) {
        this.name = name;
        this.description = description;
        this.note = note;
    }

    public ExerciseTemplate(String name) {
        this.name = name;
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

    public List<ProgramTemplate> getProgramTemplateList() {
        return programTemplateList;
    }

    public void setProgramTemplateList(List<ProgramTemplate> programTemplateList) {
        this.programTemplateList = programTemplateList;
    }

    public void addProgramTemplate(ProgramTemplate programTemplate) {
        programTemplateList.add(programTemplate);
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
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
        if (!(o instanceof ExerciseTemplate)) return false;

        ExerciseTemplate that = (ExerciseTemplate) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (!name.equals(that.name)) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String programTemplates = "";
        String exercises = "";
        for(ProgramTemplate item:programTemplateList) {
            programTemplates += "\n\t\t{id=" + item.getId() + ", name='" + item.getName() + "\'}";
        }
        for(Exercise item:exerciseList) {
            exercises += "\n\t\t{id=" + item.getId() + ", name='" + item.getName() + "\'}";
        }
        return "\nExerciseTemplate{id=" + id + ", name='" + name +
                "', \n\tprogramTemplateList=[" + programTemplates + ']' +
                ", \n\texerciseList=[" + exercises + ']' +
                '}';
    }
}
