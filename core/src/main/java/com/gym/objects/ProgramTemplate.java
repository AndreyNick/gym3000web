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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "programTemplate", cascade = CascadeType.ALL)
    List<ExerciseTemplate> exerciseTemplateList;

    public ProgramTemplate(String name, List<ExerciseTemplate> exerciseTemplateList) {
        exerciseTemplateList = new LinkedList<ExerciseTemplate>();
        this.name = name;
        this.exerciseTemplateList = exerciseTemplateList;
    }

    public ProgramTemplate() {
        exerciseTemplateList = new LinkedList<ExerciseTemplate>();
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
