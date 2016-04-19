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
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy="exerciseTemplateList")
    private List<ProgramTemplate> programTemplateList = new LinkedList<ProgramTemplate>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exerciseTemplate")
    private List<Exercise> exerciseList = new LinkedList<Exercise>();

    public ExerciseTemplate() {
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

    @Override
    public String toString() {
        String programTemplates = "";
        for(ProgramTemplate item:programTemplateList) {
            programTemplates += "{id=" + item.getId() + ", name='" + item.getName() + "\'}";
        }
        return "ExerciseTemplate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", programTemplateList=[" + programTemplates + ']' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExerciseTemplate)) return false;

        ExerciseTemplate that = (ExerciseTemplate) o;

        if (exerciseList != null ? !exerciseList.equals(that.exerciseList) : that.exerciseList != null) return false;
        if (!name.equals(that.name)) return false;
        if (programTemplateList != null ? !programTemplateList.equals(that.programTemplateList) : that.programTemplateList != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (programTemplateList != null ? programTemplateList.hashCode() : 0);
        result = 31 * result + (exerciseList != null ? exerciseList.hashCode() : 0);
        return result;
    }
}
