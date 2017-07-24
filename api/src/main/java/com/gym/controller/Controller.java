package com.gym.controller;

import com.gym.objects.User;
import com.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    public UserService userService;

    @RequestMapping(value="/",
            method = RequestMethod.GET)
    public String test() {
        return "it works test";
    }

    @RequestMapping(value="/users",
            method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.readAll();
    }

    @RequestMapping(value="/user/{id}",
            method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id) {
        return userService.read((long) id);
    }
}
