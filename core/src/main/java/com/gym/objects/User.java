package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by anni0913 on 26.09.2016.
 */

@Entity
@Table(name = "user")
public class User implements HasIdAndName {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "user_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    private String confirmPassword;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Program> programList = new LinkedList<Program>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Role> roles = new LinkedList<Role>();

    public User() {
    }

    public User(String name, String login, String password, boolean enabled) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.enabled = enabled;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Program> getProgramList() {
        return programList;
    }

    public void setProgramList(List<Program> programList) {
        this.programList = programList;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (enabled != user.enabled) return false;
        if (!login.equals(user.login)) return false;
        if (!name.equals(user.name)) return false;
        if (!password.equals(user.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
