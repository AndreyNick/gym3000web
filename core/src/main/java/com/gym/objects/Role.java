package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by anni0913 on 06.10.2016.
 */

@Entity
@Table(name = "role")
public class Role {

    public enum UserRoleType {
        USER,
        ADMIN
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "role_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "role", nullable = false)
    private UserRoleType userRoleType;

    public Role(User user, UserRoleType userRoleType) {
        this.user = user;
        this.userRoleType = userRoleType;
    }

    public Role() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRoleType getRole() {
        return userRoleType;
    }

    public void setRole(UserRoleType userRoleType) {
        this.userRoleType = userRoleType;
    }

    public Long getId() {
        return id;
    }
}
