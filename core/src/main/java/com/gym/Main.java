package com.gym;

import com.gym.objects.Attempt;
import com.gym.objects.Exercise;
import com.gym.objects.Owner;
import com.gym.objects.Training;
import com.gym.service.AttemptService;
import com.gym.service.ExerciseService;
import com.gym.service.OwnerService;
import com.gym.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by anni0913 on 25.02.2015.
 */

//@ContextConfiguration("classpath:application_context.xml")
public class Main {

    public static void main(String args[]){

        OwnerService ownerService;
        TrainingService trainingService;
        ExerciseService exerciseService;
        AttemptService attemptService;

        ApplicationContext context =
                new ClassPathXmlApplicationContext("application_context.xml");

        ownerService = (OwnerService) context.getBean("ownerService");
        trainingService = (TrainingService) context.getBean("trainingService");
        exerciseService = (ExerciseService)context.getBean("exerciseService");
        attemptService = (AttemptService) context.getBean("attemptService");

        Owner owner = new Owner("New Owner", Date.valueOf("2015-02-25"));
        ownerService.create(owner);

        Training training = new Training(owner, Date.valueOf("2015-02-27"), Training.TrainingStatus.PLANNED, 77.3,
                Time.valueOf("16:30:00"), Time.valueOf("17:30:00"), "This is note", 360.0);
        trainingService.create(training);

        Exercise exercise = new Exercise(training, Exercise.ExerciseLoad.MIDDLE, "This is note");
        exerciseService.create(exercise);

        Attempt attempt = new Attempt(exercise, 60.5, 60.5, 12, 12, "This is note");
        attemptService.create(attempt);




    }
}
