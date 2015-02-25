package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.Exercise;
import com.gym.objects.Owner;
import org.springframework.stereotype.Service;

/**
 * Created by anni0913 on 25.02.2015.
 */

@Service
public class OwnerService extends AbstractGenericService<Owner, Long> {

    protected OwnerService(GenericDao<Owner, Long> dao) {
        super(dao);
    }
}
