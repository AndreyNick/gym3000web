package com.gym.controller;

import com.gym.objects.ExerciseTemplate;
import com.gym.objects.Program;
import com.gym.objects.ProgramTemplate;
import com.gym.service.ExerciseTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ExerciseTemplateController {

    @Autowired
    ExerciseTemplateService exerciseTemplateService;

    @RequestMapping(value = "/e_temp_list")
    public String printPrograms(Map<String, Object> map) {
        map.put("exerciseTemplate", new Program());
        map.put("exerciseTemplateList", exerciseTemplateService.readAll());
        return "e_temp_list";
    }

    @RequestMapping("/e_temp_list/delete/{id}")
    public String deleteProgram(@PathVariable("id") Long id) {
        exerciseTemplateService.delete(exerciseTemplateService.read(id));
        return "redirect:/e_temp_list";
    }

    @RequestMapping(value = "/e_temp_list/add", method = RequestMethod.POST)
    public String addProgram(@ModelAttribute("exercise") ExerciseTemplate exerciseTemplate,
                             BindingResult result) {
        exerciseTemplateService.create(exerciseTemplate);
        return "redirect:/e_temp_list";
    }

    @RequestMapping("/e_temp/{id}")
    public String singleExerciseTemplate(Map<String, Object> map, @PathVariable("id") Long id) {
        ExerciseTemplate et = exerciseTemplateService.read(id);
        map.put("exerciseTemplate", et);
        map.put("programTemplate", new ProgramTemplate());
        map.put("programTemplateList", et.getProgramTemplateList());
        return "/e_temp";
    }

    @RequestMapping("/e_temp/{id}/edit_form")
    public String formEditSingleExerciseTemplate(Map<String, Object> map, @PathVariable("id") Long id) {
        ExerciseTemplate et = exerciseTemplateService.read(id);
        map.put("exerciseTemplate", et);
        map.put("programTemplate", new ProgramTemplate());
        map.put("programTemplateList", et.getProgramTemplateList());
        map.put("edit", true);
        return "/e_temp";
    }

    @RequestMapping(value = "/e_temp/{id}/edit", method = RequestMethod.POST)
    public String editSingleExerciseTemplate(@ModelAttribute("exerciseTemplate") ExerciseTemplate exerciseTemplate,
                                            @PathVariable("id") Long id) {
        //I think it would be better to get full exerciseTemplate from jsp and update it
        //not find it by id and update
        //todo: think about it
        ExerciseTemplate et = exerciseTemplateService.read(id);
        et.setName(exerciseTemplate.getName());
        et.setDescription(exerciseTemplate.getDescription());
        et.setNote(exerciseTemplate.getNote());
        exerciseTemplateService.update(et);
        return "redirect:/e_temp/" + id;
    }
}
