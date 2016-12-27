package com.gym.controller;


import com.gym.objects.Exercise;
import com.gym.objects.Set;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ExerciseController extends GenericController {

    @RequestMapping(value = "/exer/{id}", method = RequestMethod.GET)
    public String singleExercise(Map<String, Object> map,
                                @PathVariable("id") Long id) {
        Exercise e = exerciseService.read(id);
        map.put("user", getPrincipal());
        map.put("exercise", e);
        map.put("program", e.getProgram());
        map.put("set", new Set());
        map.put("setList", setService.getSetsByExerciseId(id));
        //map.put("measureValues", Set.Measure.KG, Set.Measure.POUND);
        return "/exer";
    }

    @RequestMapping(value = "/exer/{id}/edit_form")
    public String editFormSingleExercise(Map<String, Object> map,
                                @PathVariable("id") Long id) {
        Exercise e = exerciseService.read(id);
        map.put("user", getPrincipal());
        map.put("exercise", e);
        map.put("program", e.getProgram());
        map.put("set", new Set());
        map.put("setList", setService.getSetsByExerciseId(id));
        map.put("edit", true);
        return "/exer";
    }

    @RequestMapping(value = "/exer/{id}/edit", method = RequestMethod.POST)
    public String editSingleExercise(@ModelAttribute("exercise") Exercise exercise,
                                            @PathVariable("id") Long id) {

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
