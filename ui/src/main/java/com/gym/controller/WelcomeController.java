package com.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }
}
