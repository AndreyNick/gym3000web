package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

    public ExerciseTemplate(String name) {
        this.name = name;
    }

    public ExerciseTemplate() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExerciseTemplate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private ProgramTemplate programTemplate;

    public ProgramTemplate getProgramTemplates() {
        return programTemplate;
    }

    public void setProgramTemplates(ProgramTemplate programTemplates) {
        this.programTemplate = programTemplates;
    }
}
