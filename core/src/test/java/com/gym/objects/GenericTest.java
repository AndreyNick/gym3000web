package com.gym.objects;

import com.gym.dao.GenericDao;
import com.gym.dao.impl.GenericDaoImpl;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runner.manipulation.Sortable;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(value = Parameterized.class)
@ContextConfiguration("classpath:test_config.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional

/**
 * TODO We need to set in GenericDao different types of product with different inner parameters, so we can't use @Parameters
 *
 * */
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

    @Ignore
    @Test
    public void createTest(){
        //genericDao



    }

    @Ignore
    @Test
    public void readTest(){
    }

    @Ignore
    @Test
    public void updateTest(){
    }

    @Ignore
    @Test
    public void deleteTest(){
    }

    @Ignore
    @Test
    public void readAllTest(){
    }

    public void compare(Object selected, Object testObject) {
        assertNotNull("selected is null", selected);
        assertTrue(selected.equals(testObject));
    }
}