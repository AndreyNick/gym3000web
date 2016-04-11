package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
        this.name = name;
        this.exerciseTemplateList = exerciseTemplateList;
    }

    public ProgramTemplate() {
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

    @Override
    public String toString() {
        return "ProgramTemplate{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
