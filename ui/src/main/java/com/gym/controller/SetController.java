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
public class SetController extends GenericController{

    @RequestMapping(value = "/exer/{id}/add", method = RequestMethod.POST)
    public String addProgram(@ModelAttribute("user") Set set,
                             @PathVariable("id") Long id) {
        set.setExercise(exerciseService.read(id));
        setService.create(set);
        return "redirect:/exer/" + id;
    }

    @RequestMapping(value = "/exer/{exerciseId}/delete/{setId}")
    public String deleteExerciseFromProgram(
            @PathVariable("exerciseId") Long exerciseId,
            @PathVariable("setId") Long setId) {
        Exercise e = exerciseService.read(exerciseId);
        Set s = setService.read(setId);
        e.deleteSet(s);
        exerciseService.update(e);
        setService.delete(s);
        return "redirect:/exer/" + exerciseId;
    }

    @RequestMapping(value = "/exer/{exerciseId}/edit_form/{setId}")
    public String editSingleExercise(Map<String, Object> map,
                                     @PathVariable("exerciseId") Long exerciseId,
                                     @PathVariable("setId") Long setId) {
        Exercise e = exerciseService.read(exerciseId);
        map.put("user", getPrincipal());
        map.put("exercise", e);
        map.put("program", e.getProgram());
        map.put("set", new Set());
        map.put("setList", setService.getSetsByExerciseId(exerciseId));
        map.put("edit_set", setId);
        return "/exer";
    }

    @RequestMapping(value = "/exer/{exerciseId}/edit/{setId}", method = RequestMethod.POST)
    public String editSingleProgramTemplate(@ModelAttribute("set") Set set,
                                            @PathVariable("exerciseId") Long exerciseId,
                                            @PathVariable("setId") Long setId) {
        Set s = setService.read(setId);
        s.setExercise(exerciseService.read(exerciseId));
        s.setWeight(set.getWeight());
        s.setTimes(set.getTimes());
        s.setMeasure(set.getMeasure());
        setService.update(s);
        return "redirect:/exer/" + exerciseId;
    }
}
