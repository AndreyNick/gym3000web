package com.gym.service;

import com.gym.dao.impl.RoleDaoImpl;
import com.gym.objects.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RoleService extends AbstractGenericService<Role, Long> {

    private RoleDaoImpl rdi;

    protected RoleService(RoleDaoImpl rdi) {
        super(rdi);
        this.rdi = rdi;
    }

    @Transactional(readOnly = true)
    public List<Role> getRolesByUserId(Long userId) {
        return rdi.getRolesByUserId(userId);
    }
}
