package com.gym.controller;

import com.gym.objects.Role;
import com.gym.objects.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class RegistrationController extends GenericController {

    @RequestMapping(value = "/register/add", method = RequestMethod.POST)
    public String addProgram(@ModelAttribute("user") User user) {
        user.setEnabled(true); //todo maybe creation user should be removed from here
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
