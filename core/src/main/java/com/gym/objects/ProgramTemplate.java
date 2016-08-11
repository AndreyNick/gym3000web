package com.gym.objects;

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

    public ProgramTemplate() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgramTemplate)) return false;

        ProgramTemplate template = (ProgramTemplate) o;

        if (!name.equals(template.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
