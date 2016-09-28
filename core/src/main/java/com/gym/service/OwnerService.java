package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.Owner;

/**
 * Created by anni0913 on 27.09.2016.
 */
public class OwnerService extends AbstractGenericService<Owner, Long> {
    protected OwnerService(GenericDao<Owner, Long> dao) {
        super(dao);
    }
}
