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
    Program expectedProgram1;
    @Autowired
    Program expectedProgram2;

    //@Ignore
    @Override
    @Test(expected = ObjectNotFoundException.class)
    public void crudTest(){

        idNotNull(programService.create(expectedProgram1));
        Program readProgram = programService.read(expectedProgram1.getId());
        compare(readProgram, expectedProgram1);

        expectedProgram1.setName("Program for testing updated");
        programService.update(expectedProgram1);
        readProgram = programService.read(expectedProgram1.getId());
        compare(readProgram, expectedProgram1);

        programService.create(expectedProgram2);

        List<Program> actualList = programService.readAll();

        List<Program> expectedList = new LinkedList<Program>();
        expectedList.add(expectedProgram1);
        expectedList.add(expectedProgram2);

        compareLists(expectedList, actualList);

        programService.delete(expectedProgram1);
        programService.delete(expectedProgram2);

        readProgram = programService.read(expectedProgram1.getId());
        readProgram.toString();
    }
}
