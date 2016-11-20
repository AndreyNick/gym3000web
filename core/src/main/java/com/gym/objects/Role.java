package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by anni0913 on 06.10.2016.
 */

@Entity
@Table(name = "role")
public class Role {

    public static String ADMIN = "ADMIN";
    public static String USER = "USER";

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "role_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "role", nullable = false)
    private String role;

    public Role(User user, String role) {
        this.user = user;
        this.role = role;
    }

    public Role() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String  role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role1 = (Role) o;

        if (!role.equals(role1.role)) return false;
        if (!user.equals(role1.user)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", user=" + user.getLogin() +
                ", role='" + role + '\'' +
                '}';
    }
}
