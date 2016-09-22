package com.gym.controller;


import com.gym.objects.Exercise;
import com.gym.objects.Program;
import com.gym.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @RequestMapping(value = "/exer/{id}", method = RequestMethod.GET)
    public String singleProgram(Map<String, Object> map, @PathVariable("id") Long id) {
        Exercise e =  exerciseService.read(id);
        Program p = e.getProgram();

        map.put("exercise", e);
        map.put("program", p);
        return "/exer";
    }
}
