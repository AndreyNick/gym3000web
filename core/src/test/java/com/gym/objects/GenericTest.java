package com.gym.objects;

import com.gym.dao.GenericDao;
import com.gym.dao.impl.GenericDaoImpl;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class GenericTest {

    public GenericTest(String beanName){
        genericDao = (GenericDaoImpl) ac.getBean(beanName);
    }

    GenericDao genericDao;
    static ApplicationContext ac;

    @BeforeClass
    public static void instantiateEntities(){
        ac = new ClassPathXmlApplicationContext("test_config.xml");
    }

    @Parameters()
    public static List<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {"programDao"},
                {"workoutDao"},
                {"exerciseDao"},
                {"attemptDao"},
        });
    }

    @Test
    public void createTest(){

    }

    @Test
    public void readTest(){
    }


    @Test
    public void updateTest(){
    }


    @Test
    public void deleteTest(){
    }


    @Test
    public void readAllTest(){
    }
}