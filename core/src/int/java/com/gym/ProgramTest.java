package com.gym;

import com.gym.objects.User;
import com.gym.objects.Program;
import com.gym.service.UserService;
import com.gym.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test class for ProgramService
 */
public class ProgramTest extends GenericTest{

    @Autowired
    ProgramService programService;
    @Autowired
    UserService userService;
    @Autowired
    User user1;
    @Autowired
    Program program1;
    @Autowired
    Program program2;
    @Autowired
    Program equalProgram1;
    @Autowired
    Program equalProgram2;

    @Override
    public void init() {
        setExpected(program1);
        setService(programService);
    }

    @Override
    public void saveTransientObjectsIfNeed() {
        userService.create(user1);
    }
}
