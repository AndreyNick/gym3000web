package com.gym.objects;

import com.gym.dao.GenericDao;
import com.gym.dao.impl.GenericDaoImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class GenericTest {

    GenericTest(String beanName){
        genericDao = (GenericDaoImpl) ac.getBean(beanName);
    }

    GenericDao genericDao;
    static ApplicationContext ac;

    @BeforeClass
    public static void instantiateEntities(){
        ac = new ClassPathXmlApplicationContext("test_config.xml") ;
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


    @Parameterized.Parameters
    public static List<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {"programDao"},
                {"workoutDao"},
                {"exerciseDao"},
                {"attemptDao"},
        });
    }
}