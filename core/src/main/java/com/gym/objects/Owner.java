package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by anni0913 on 26.09.2016.
 */

@Entity
@Table(name = "owner")
public class Owner implements HasIdAndName {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "owner_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Program> programList = new LinkedList<Program>();

    public Owner(String name) {
        this.name = name;
    }

    public Owner() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public List<Program> getProgramList() {
        return programList;
    }

    public void setProgramList(List<Program> programList) {
        this.programList = programList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        if (!name.equals(owner.name)) return false;
        return programList != null ? programList.equals(owner.programList) : owner.programList == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (programList != null ? programList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", programList=" + programList +
                '}';
    }
}
