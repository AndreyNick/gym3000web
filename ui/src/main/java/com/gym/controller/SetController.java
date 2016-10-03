package com.gym.controller;

import com.gym.objects.Set;
import com.gym.service.ExerciseService;
import com.gym.service.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SetController {

    @Autowired
    SetService setService;

    @Autowired
    ExerciseService exerciseService;

    @RequestMapping(value = "/exer/{id}/add", method = RequestMethod.POST)
    public String addProgram(@ModelAttribute("user") Set set,
                             @PathVariable("id") Long id) {
        set.setExercise(exerciseService.read(id));
        setService.create(set);
        return "redirect:/exer/" + id;
    }
}
