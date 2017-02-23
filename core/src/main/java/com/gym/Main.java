package com.gym;

import com.gym.objects.Program;
import com.gym.service.ExerciseService;
import com.gym.service.ExerciseTemplateService;
import com.gym.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    @Autowired
    ProgramService programService;

    @Autowired
    ExerciseTemplateService exerciseTemplateService;

    @Autowired
    ExerciseService exerciseService;

    public static void main(String args[]) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("main_context.xml");
        ProgramService ps = (ProgramService) ac.getBean("programService");
        List<Program> programs =  ps.readAll();
        System.out.println("programService.readAll() = " + programs);
        Program p = ps.read((long) 1);
        System.out.println("programService.read(1) = " + p);
        System.out.println("Exercises = " + p.getExerciseList());
    }

    void readSmth() {
        List<String> stringList = new LinkedList<>();
        Queue<String> stringQueue = new LinkedList<>();

    }
}
