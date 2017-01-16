package com.gym.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    //@Autowired
    //public UserService userService;

    /*@RequestMapping(value="/users",
            method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.readAll();
    }*/

    @RequestMapping(value="/test",
            method = RequestMethod.GET)
    public String test() {
        return "test";
    }


}
