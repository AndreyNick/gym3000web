package com.gym.objects;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the class for program template.
 * A program could be created from ProgramTemplate, but it doesn't contain the link to a template.
 * Program could be created even without template.
 */
@Entity
@Table(name = "program_template")
public class ProgramTemplate implements HasIdAndName {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "program_template_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name="program_exercise_templates",
            joinColumns={@JoinColumn(name="program_template_id")},
            inverseJoinColumns={@JoinColumn(name="exercise_template_id")})
    private List<ExerciseTemplate> exerciseTemplateList = new LinkedList<ExerciseTemplate>();

    @Column(name = "description")
    private String description;

    @Column(name = "note")
    private String note;

    public ProgramTemplate() {
    }

    public ProgramTemplate(String name, String description, String note) {
        this.name = name;
        this.description = description;
        this.note = note;
    }

    public ProgramTemplate(String name) {
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

    public List<ExerciseTemplate> getExerciseTemplateList() {
        return exerciseTemplateList;
    }

    public void setExerciseTemplateList(List<ExerciseTemplate> exerciseTemplateList) {
        this.exerciseTemplateList = exerciseTemplateList;
    }

    public void addExerciseTemplate(ExerciseTemplate exerciseTemplate) {
        exerciseTemplateList.add(exerciseTemplate);
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
        if (!(o instanceof ProgramTemplate)) return false;

        ProgramTemplate template = (ProgramTemplate) o;

        if (description != null ? !description.equals(template.description) : template.description != null)
            return false;
        if (exerciseTemplateList != null ? !exerciseTemplateList.equals(template.exerciseTemplateList) : template.exerciseTemplateList != null)
            return false;
        if (!name.equals(template.name)) return false;
        if (note != null ? !note.equals(template.note) : template.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (exerciseTemplateList != null ? exerciseTemplateList.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String exerciseTemplates = "";
        for(ExerciseTemplate item:exerciseTemplateList) {
            exerciseTemplates += "\n\t\t{id=" + item.getId() + ", name='" + item.getName() + "\'}";
        }
        return "\nProgramTemplate{id=" + id + ", name='" + name +
                "', \n\texerciseTemplateList=[" + exerciseTemplates + ']' +
                '}';
    }
}
