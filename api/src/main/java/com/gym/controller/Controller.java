package com.gym.controller;

import com.gym.objects.User;
import com.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class Controller {

    @Autowired
    public UserService userService;

    @RequestMapping(value="/users",
            method = RequestMethod.GET,
            headers="Accept=application/json")
    @ResponseBody
    public List<User> getUsers() {
        return userService.readAll();
    }

    @RequestMapping(value="/test",
            method = RequestMethod.GET,
            headers="Accept=application/json")
    @ResponseBody
    public String test() {
        return "test";
    }


}
