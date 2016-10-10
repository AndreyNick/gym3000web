package com.gym.service;

import com.gym.dao.GenericDao;
import com.gym.objects.Role;

public class RoleService extends AbstractGenericService<Role, Long> {

    protected RoleService(GenericDao<Role, Long> dao) {
        super(dao);
    }
}
