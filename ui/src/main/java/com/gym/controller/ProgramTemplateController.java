package com.gym.controller;

import com.gym.factory.ProgramFactory;
import com.gym.objects.ExerciseTemplate;
import com.gym.objects.ProgramTemplate;
import com.gym.service.ExerciseTemplateService;
import com.gym.service.ProgramTemplateService;
import com.gym.validator.ProgramTemplateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ProgramTemplateController {

    @Autowired
    ProgramTemplateService programTemplateService;

    @Autowired
    ExerciseTemplateService exerciseTemplateService;

    @Autowired
    ProgramFactory programFactory;

    @Autowired
    @Qualifier("programTemplateValidator")
    private ProgramTemplateValidator programTemplateValidator;

    @InitBinder("programTemplate")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(programTemplateValidator);
    }

    @RequestMapping(value = "/p_temp_list")
    public String programTemplateList(Map<String, Object> map) {
        map.put("programTemplate", new ProgramTemplate());
        map.put("programTemplateList", programTemplateService.readAll());
        return "p_temp_list";
    }

    @RequestMapping("/p_temp_list/delete/{id}")
    public String deleteProgramTemplate(@PathVariable("id") Long id) {
        programTemplateService.delete(programTemplateService.read(id));
        return "redirect:/p_temp_list";
    }

    @RequestMapping("/p_temp_list/create_program/{id}")
    public String createNewProgramByProgramTemplate(@PathVariable("id") Long id) {
        ProgramTemplate pt = programTemplateService.read(id);
        programFactory.createProgram(pt);
        return "redirect:/p_temp_list";
    }

    @RequestMapping(value = "/p_temp_list/add", method = RequestMethod.POST)
    public String addProgramTemplate(@ModelAttribute("programTemplate") /*@Validated  */ProgramTemplate programTemplate,
                                     BindingResult result) {
        if (result.hasErrors()) {
              System.out.print("ERROR");
            return "/p_temp_list";
        } else {
            programTemplateService.create(programTemplate);
            return "redirect:/p_temp_list";
        }
    }

    @RequestMapping("/p_temp/{id}")
    public String singleProgramTemplate(Map<String, Object> map, @PathVariable("id") Long id) {
        ProgramTemplate pt =  programTemplateService.read(id);
        map.put("programTemplate", pt);
        map.put("exerciseTemplate", new ExerciseTemplate());
        map.put("exerciseTemplateList", pt.getExerciseTemplateList());
        map.put("exerciseTemplateListAll", exerciseTemplateService.readAll());
        return "/p_temp";
    }

    @RequestMapping("/p_temp/{id}/edit_form")
    public String editFormSingleProgramTemplate(Map<String, Object> map, @PathVariable("id") Long id) {
        ProgramTemplate pt =  programTemplateService.read(id);
        map.put("programTemplate", pt);
        map.put("exerciseTemplate", new ExerciseTemplate());
        map.put("exerciseTemplateList", pt.getExerciseTemplateList());
        map.put("exerciseTemplateListAll", exerciseTemplateService.readAll());
        map.put("edit", true);
        return "/p_temp";
    }

    @RequestMapping(value = "/p_temp/{id}/edit", method = RequestMethod.POST)
    public String editSingleProgramTemplate(@ModelAttribute("programTemplate") /*@Validated*/ ProgramTemplate programTemplate,
                                            @PathVariable("id") Long id,
                                            BindingResult result) {

        if (result.hasErrors()) {
            System.out.println("ERROR.");
            return "redirect:/p_temp/" + id + "/edit_form";
        } else {
            ProgramTemplate pt = programTemplateService.read(id);
            pt.setName(programTemplate.getName());
            pt.setDescription(programTemplate.getDescription());
            pt.setNote(programTemplate.getNote());
            programTemplateService.update(pt);
            return "redirect:/p_temp/" + id;
            //i think it would be better to get full programTemplate from jsp and update it
            //not find it by id and update
            //todo: think about it
        }

    }

    @RequestMapping(value = "/p_temp/{programTemplateId}/bind/{exerciseTemplateId}")
    public String bindExerciseTemplateToProgramTemplate(
            @PathVariable("programTemplateId") Long programTemplateId,
            @PathVariable("exerciseTemplateId") Long exerciseTemplateId) {
        ProgramTemplate pt = programTemplateService.read(programTemplateId);
        List<ExerciseTemplate> etl = pt.getExerciseTemplateList();
        etl.add(exerciseTemplateService.read(exerciseTemplateId));
        programTemplateService.update(pt);
        return "redirect:/p_temp/" + programTemplateId;
    }

    @RequestMapping(value = "/p_temp/{programTemplateId}/unbind/{exerciseTemplateId}")
    public String unbindExerciseTemplateFromProgramTemplate(
            @PathVariable("programTemplateId") Long programTemplateId,
            @PathVariable("exerciseTemplateId") Long exerciseTemplateId) {
        ProgramTemplate pt = programTemplateService.read(programTemplateId);
        List<ExerciseTemplate> etl = pt.getExerciseTemplateList();
        etl.remove(exerciseTemplateService.read(exerciseTemplateId));
        programTemplateService.update(pt);
        return "redirect:/p_temp/" + programTemplateId;
    }
}
