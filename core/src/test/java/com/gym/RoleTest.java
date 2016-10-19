package com.gym;

import com.gym.objects.Role;
import com.gym.objects.User;
import com.gym.service.RoleService;
import com.gym.service.UserService;
import junit.framework.Assert;
import org.hibernate.ObjectNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:generic_test_context.xml")
public class RoleTest {

    @Autowired
    UserService userService;

    @Autowired
    User user1;

    @Autowired
    RoleService roleService;

    @Autowired
    Role roleAdm;

    @Autowired
    Role roleUser;

    @Test
    @Transactional
    @Rollback(true)
    public void createAndReadEntity() {
        userService.create(user1);
        roleService.create(roleAdm);
        Assert.assertEquals(roleAdm, roleService.read(roleAdm.getId()));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateEntity() {
        userService.create(user1);
        roleService.create(roleAdm);
        roleAdm.setRole(Role.UserRoleType.ADMIN);
        roleService.update(roleAdm);
        Assert.assertEquals(roleAdm, roleService.read(roleAdm.getId()));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void deleteEntity() throws ObjectNotFoundException {
        userService.create(user1);
        roleService.create(roleAdm);
        Long id = roleAdm.getId();
        roleService.delete(roleAdm);
        roleService.read(id);
    }
}
