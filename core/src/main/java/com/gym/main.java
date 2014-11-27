package com.gym;

import com.gym.dao.GenericDao;
import com.gym.dao.impl.GenericDaoImpl;
import com.gym.objects.Program;
import com.gym.objects.Workout;
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
        GenericDao dao = (GenericDaoImpl) ac.getBean("programDao");
        Program p2 = new Program("test program #5", "test description 5");
        List<Workout> workoutList = new LinkedList<Workout>();
        Workout w1 = new Workout(p2, "test workout 10", "descr 10", 0);
        Workout w2 = new Workout(p2, "test workout 11", "descr 11", 0);
        Workout w3 = new Workout(p2, "test workout 12", "descr 12", 0);
        workoutList.add(w1);
        workoutList.add(w2);
        workoutList.add(w3);
        p2.setWorkoutList(workoutList);
        dao.create(p2);





    }
}
