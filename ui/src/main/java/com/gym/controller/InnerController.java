package com.gym.controller;

import com.gym.service.ExerciseService;
import com.gym.service.ExerciseTemplateService;
import com.gym.service.ProgramService;
import com.gym.service.ProgramTemplateService;
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

    @Autowired
    ProgramTemplateService programTemplateService;

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    ExerciseTemplateService exerciseTemplateService;



    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/p_temp";
    }

    @RequestMapping(value = "/p_temp")
    public String welcome(Map<String, Object> map) {
        map.put("program_templates_list", programTemplateService.readAll());
        return "p_temp";
    }

}
