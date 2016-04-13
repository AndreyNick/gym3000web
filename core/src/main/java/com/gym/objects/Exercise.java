package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "exercise_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_template_id", nullable = false)
    private ExerciseTemplate exerciseTemplate;

    @Column(name = "name")
    private String name;

    public Exercise() {
    }

    public Exercise(String name, ExerciseTemplate exerciseTemplate) {
        this.name = name;
        this.exerciseTemplate = exerciseTemplate;
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
}
