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

    @RequestMapping(value = "/exer/{id}", method = RequestMethod.GET)
    public String singleExercise(Map<String, Object> map,
                                @PathVariable("id") Long id) {
        Exercise e = exerciseService.read(id);
        Program p = e.getProgram();
        map.put("exercise", e);
        map.put("program", p);
        return "/exer";
    }

    @RequestMapping(value = "/exer/{id}/edit_form")
    public String editFormSingleExercise(Map<String, Object> map,
                                @PathVariable("id") Long id) {
        Exercise e = exerciseService.read(id);
        Program p = e.getProgram();
        map.put("exercise", e);
        map.put("program", p);
        map.put("edit", true);
        return "/exer";
    }

    @RequestMapping(value = "/exer/{id}/edit", method = RequestMethod.POST)
    public String editSingleExercise(@ModelAttribute("exercise") /*@Validated*/ Exercise exercise,
                                            @PathVariable("id") Long id,
                                            BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("ERROR.");
            return "redirect:/prog/" + id + "/edit_form";
        } else {
            Exercise e = exerciseService.read(id);
            e.setName(exercise.getName());
            e.setDescription(exercise.getDescription());
            e.setNote(exercise.getNote());
            exerciseService.update(e);
            return "redirect:/exer/" + id;
            //i think it would be better to get full program from jsp and update it
            //not find it by id and update
            //todo: think about it
        }
    }
}
