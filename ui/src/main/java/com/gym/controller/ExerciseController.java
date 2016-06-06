package com.gym.controller;


import com.gym.objects.Exercise;
import com.gym.objects.Program;
import com.gym.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @RequestMapping(value = "/exer")
    public String printPrograms(Map<String, Object> map) {
        map.put("exercise", new Program());
        map.put("exerciseList", exerciseService.readAll());
        return "exer";
    }

    @RequestMapping("/exer/delete/{id}")
    public String deleteProgram(@PathVariable("id") Long id) {
        exerciseService.delete(exerciseService.read(id));
        return "redirect:/exer";
    }

    @RequestMapping(value = "/exer/add", method = RequestMethod.POST)
    public String addProgram(@ModelAttribute("exercise") Exercise exercise,
                             BindingResult result) {
        exerciseService.create(exercise);
        return "redirect:/exer";
    }
}
