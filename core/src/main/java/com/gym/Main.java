package com.gym;

import com.gym.objects.Owner;
import com.gym.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Date;

/**
 * Created by anni0913 on 25.02.2015.
 */

//@ContextConfiguration("classpath:application_context.xml")
public class Main {

    public static void main(String args[]){

        OwnerService ownerService;

        ApplicationContext context =
                new ClassPathXmlApplicationContext("application_context.xml");

        ownerService = (OwnerService) context.getBean("ownerService");

        Owner owner = new Owner("Test Owner", Date.valueOf("1989-01-01"));
        ownerService.create(owner);



    }
}
