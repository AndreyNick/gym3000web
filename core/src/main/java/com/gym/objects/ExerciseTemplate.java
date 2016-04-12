package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "exercise_template")
public class ExerciseTemplate {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "exercise_template_id", unique = true, nullable = false)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @ManyToMany(mappedBy="exerciseTemplateList")
    List<ProgramTemplate> programTemplateList = new LinkedList<ProgramTemplate>();


    public ExerciseTemplate() {
    }

    public ExerciseTemplate(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "ExerciseTemplate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
