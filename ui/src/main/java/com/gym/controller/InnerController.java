package com.gym.controller;

import com.gym.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class InnerController {

    @Autowired
    ProgramService programService;

    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/inner";
    }

    @RequestMapping(value = "/inner")
    public String welcome(Map<String, Object> map) {
        map.put("program", programService.readAll().toString());
        return "inner";
    }

}
