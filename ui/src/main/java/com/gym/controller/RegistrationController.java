package com.gym.controller;

import com.gym.objects.Role;
import com.gym.objects.User;
import com.gym.service.RoleService;
import com.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/register/add", method = RequestMethod.POST)
    public String addProgram(@ModelAttribute("user") User user) {
        user.setEnabled(true);
        userService.create(user);
        roleService.create(new Role(user, Role.USER));
        return "redirect:/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String welcome(Map<String, Object> map) {
        map.put("user", new User());
        return "register";
    }
}
