package com.gym.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by AndreyNick on 02.09.2014.
 */

@Entity
@Table(name = "attempt")
public class Attempt{

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "attempt_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(name = "weight", nullable = false)
    private Double weight;

    /**
     * This field shows how many times you did in your attempt
     */
    @Column(name = "times", nullable = false)
    private int actualTimes;

    /**
     * This field shows how many times you should do in your attempt
     * in case you write plan before training
     */
    private String neededTimes;

}
