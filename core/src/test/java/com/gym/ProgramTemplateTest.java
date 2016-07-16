package com.gym;

import com.gym.objects.ProgramTemplate;
import com.gym.service.ProgramTemplateService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test class for ProgramTemplateService
 */
public class ProgramTemplateTest extends GenericTest {

    @Autowired
    ProgramTemplateService programTemplateService;
    @Autowired
    ProgramTemplate programTemplate1;

    @Override
    public void init() {
        setExpected(programTemplate1);
        setService(programTemplateService);
    }
}
