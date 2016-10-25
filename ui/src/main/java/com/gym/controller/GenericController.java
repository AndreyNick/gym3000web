package com.gym.controller;

import com.gym.factory.ProgramFactory;
import com.gym.objects.User;
import com.gym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
public class GenericController {

    @Autowired
    ProgramTemplateService programTemplateService;

    @Autowired
    ProgramFactory programFactory;

    @Autowired
    SetService setService;

    @Autowired
    RoleService roleService;

    @Autowired
    ProgramService programService;

    @Autowired
    ExerciseTemplateService exerciseTemplateService;

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    UserService userService;

    protected User getPrincipal(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return userService.readByName(((UserDetails)principal).getUsername());
        } else {
            return null;
        }
    }

}
