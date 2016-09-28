package com.gym;

import com.gym.objects.Owner;
import com.gym.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public class OwnerTest extends GenericTest {

    @Autowired
    OwnerService ownerService;

    @Autowired
    Owner owner1;

    @Autowired
    Owner owner2;

    @Override
    public void init() {
        setExpected(owner1);
        setService(ownerService);
    }
}
