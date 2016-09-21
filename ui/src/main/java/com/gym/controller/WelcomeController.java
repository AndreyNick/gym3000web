package com.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/welcome")
    public String welcome(Locale locale, Model model) {
        model.addAttribute("locale", locale);
        return "welcome";
    }
}
