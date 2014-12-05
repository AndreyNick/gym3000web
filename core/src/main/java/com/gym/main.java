package com.gym;

import com.gym.dao.GenericDao;
import com.gym.dao.impl.GenericDaoImpl;
import com.gym.objects.Program;
import com.gym.objects.Workout;
import com.gym.service.AbstractGenericService;
import com.gym.service.ProgramService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by anni0913 on 27.11.2014.
 */
public class Main {
    public static void main(String args[]){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application_context.xml");
        ProgramService service = (ProgramService) ac.getBean("programService");

        Program p2 = new Program("test program insert", "test description insert1");
        List<Workout> workoutList = new LinkedList<Workout>();
        Workout w1 = new Workout(p2, "test workout ins1", "descr1", 0);
        Workout w2 = new Workout(p2, "test workout ins2", "descr2", 0);
        Workout w3 = new Workout(p2, "test workout ins3", "descr3", 0);
        workoutList.add(w1);
        workoutList.add(w2);
        workoutList.add(w3);
        p2.setWorkoutList(workoutList);
        service.create(p2);
        System.out.println(p2.getId());


        Program p1 = new Program("test program update", "test description update");
        List<Workout> workoutList1 = new LinkedList<Workout>();
        Workout w5 = new Workout(p1, "test workout up", "descr", 0);
        Workout w6 = new Workout(p1, "test workout up", "descr", 0);
        Workout w7 = new Workout(p1, "test workout up", "descr", 0);
        workoutList.add(w5);
        workoutList.add(w6);
        workoutList.add(w7);
        p1.setWorkoutList(workoutList1);
        p2.setName("another name");
        service.update(p2);


        //System.out.println(String.valueOf(id));
        //Program program1 = service.read(id);





    }
}
