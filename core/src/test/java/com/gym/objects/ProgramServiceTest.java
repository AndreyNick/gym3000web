package com.gym.objects;

import com.gym.service.ProgramService;
import org.hibernate.ObjectNotFoundException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by anni0913 on 08.12.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test_config.xml")
public class ProgramServiceTest extends AbstractServiceTest{

    @Autowired
    ProgramService programService;

    @Autowired
    Program testProgram1;

    @Autowired
    Program testProgram2;



    //@Ignore
    @Override
    @Test(expected = ObjectNotFoundException.class)
    public void crudTest(){

        idNotNull(programService.create(testProgram1));
        Program readProgram = programService.read(testProgram1.getId());
        compare(readProgram, testProgram1);

        testProgram1.setName("Program for testing updated");
        programService.update(testProgram1);
        readProgram = programService.read(testProgram1.getId());
        compare(readProgram, testProgram1);

        programService.create(testProgram2);

        List<Program> actualList = programService.readAll();

        List<Program> expectedList = new LinkedList<Program>();
        expectedList.add(testProgram1);
        expectedList.add(testProgram2);

        compareLists(expectedList, actualList);

        programService.delete(testProgram1);
        programService.delete(testProgram2);

        readProgram = programService.read(testProgram1.getId());
        readProgram.toString();
    }

    @Ignore
    @Test(expected = ObjectNotFoundException.class)
    public void test(){
        //testProgram.setId(new Long("45"));
        programService.create(testProgram1);

    }



}
