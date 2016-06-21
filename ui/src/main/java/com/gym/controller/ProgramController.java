package com.gym.controller;

import com.gym.objects.Exercise;
import com.gym.objects.ExerciseTemplate;
import com.gym.objects.Program;
import com.gym.objects.ProgramTemplate;
import com.gym.service.ExerciseService;
import com.gym.service.ExerciseTemplateService;
import com.gym.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class ProgramController {

    @Autowired
    ProgramService programService;

    @Autowired
    ExerciseTemplateService exerciseTemplateService;

    @Autowired
    ExerciseService exerciseService;

    @RequestMapping(value = "/prog_list")
    public String printPrograms(Map<String, Object> map) {
        map.put("program", new Program());
        map.put("programList", programService.readAll());
        return "prog_list";
    }

    @RequestMapping("/prog_list/delete/{id}")
    public String deleteProgram(@PathVariable("id") Long id) {
        programService.delete(programService.read(id));
        return "redirect:/prog_list";
    }

    @RequestMapping(value = "/prog_list/add", method = RequestMethod.POST)
    public String addProgram(@ModelAttribute("program") Program program,
                             BindingResult result) {
        programService.create(program);
        return "redirect:/prog_list";
    }

    @RequestMapping("/prog/{id}")
    public String singleProgram(Map<String, Object> map, @PathVariable("id") Long id) {
        Program p =  programService.read(id);
        map.put("program", p);
        map.put("exercise", new Exercise());
        map.put("exerciseTemplate", new ExerciseTemplate());
        map.put("exerciseList", p.getExerciseList());
        System.out.println(p.getExerciseList());
        map.put("exerciseTemplateListAll", exerciseTemplateService.readAll());
        return "/prog";
    }

    @RequestMapping(value = "/prog/{programId}/add/{exerciseTemplateId}")
    public String addExerciseToProgram(
            @PathVariable("programId") Long programId,
            @PathVariable("exerciseTemplateId") Long exerciseTemplateId) {
        Program p = programService.read(programId);
        ExerciseTemplate et = exerciseTemplateService.read(exerciseTemplateId);
        exerciseService.create(new Exercise(p, et, et.getName()));
        return "redirect:/prog/" + programId;
    }

    @RequestMapping(value = "/prog/{programId}/delete/{exerciseId}")
    public String deleteExerciseFromProgram(
            @PathVariable("programId") Long programId,
            @PathVariable("exerciseId") Long exerciseId) {
        exerciseService.delete(exerciseService.read(exerciseId));
        return "redirect:/prog/" + programId;
    }
}
