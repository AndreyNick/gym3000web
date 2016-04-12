package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "program_template")
public class ProgramTemplate {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "program_template_id", unique = true, nullable = false)
    Long id;

    @Column(name = "name", nullable = false)
    String name;


    @ManyToMany
    @JoinTable(name="program_exercise_templates",
            joinColumns={@JoinColumn(name="program_template_id")},
            inverseJoinColumns={@JoinColumn(name="exercise_template_id")})
    List<ExerciseTemplate> exerciseTemplateList = new LinkedList<ExerciseTemplate>();

    public ProgramTemplate() {
    }

    public ProgramTemplate(String name) {
        this.name = name;
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
        return "ProgramTemplate{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
