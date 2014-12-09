package com.gym.objects;

import com.gym.service.ProgramService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by anni0913 on 08.12.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test_config.xml")
public class ProgramServiceTest extends AbstractServiceTest{

    @Autowired
    ProgramService programService;
    @Autowired
    Program testProgram;

    @Override
    @Test
    public void crudTest(){

        programService.create(testProgram);
        Program readProgram = programService.read(testProgram.getId());
        compare(readProgram, testProgram);

        programService.update(testProgram);
        readProgram = programService.read(testProgram.getId());
        compare(readProgram, testProgram);

        //testProgram.setId(Long.parseLong("4"));
        programService.delete(testProgram);
        readProgram = programService.read(testProgram.getId());
        assertNull(readProgram);
    }

    @Override
    @Test
    @Ignore
    public void readAllTest(){

    }
}
