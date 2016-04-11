package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.ProgramTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProgramTemplateService extends AbstractGenericService<ProgramTemplate, Long> {

    protected ProgramTemplateService(GenericDao<ProgramTemplate, Long> dao) {
        super(dao);
    }
}
