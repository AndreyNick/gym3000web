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
    public ProgramTemplateService programTemplateService;

    @Autowired
    public ProgramFactory programFactory;

    @Autowired
    public SetService setService;

    @Autowired
    public RoleService roleService;

    @Autowired
    public ProgramService programService;

    @Autowired
    public ExerciseTemplateService exerciseTemplateService;

    @Autowired
    public ExerciseService exerciseService;

    @Autowired
    public UserService userService;

    protected User getPrincipal(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            System.out.println("principal: " + ((UserDetails)principal).getUsername());
            return userService.readByLogin(((UserDetails)principal).getUsername());
        } else {
            return null;
        }
    }

}
