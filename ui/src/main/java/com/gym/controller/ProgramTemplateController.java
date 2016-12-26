package com.gym.controller;

import com.gym.objects.ExerciseTemplate;
import com.gym.objects.ProgramTemplate;
import com.gym.objects.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class ProgramTemplateController extends GenericController {

    /*@Autowired
    @Qualifier("programTemplateValidator")
    private ProgramTemplateValidator programTemplateValidator;

    @InitBinder("programTemplate")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(programTemplateValidator);
    }*/

    @RequestMapping(value = "/p_temp_list")
    public String programTemplateList(Map<String, Object> map) {
        map.put("user", getPrincipal());
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
        User user = getPrincipal();
        Long newProgramId = programFactory.createProgram(pt, user);
        return "redirect:/prog/" + newProgramId;
    }

    @RequestMapping(value = "/p_temp_list/add", method = RequestMethod.POST)
    public String addProgramTemplate(@ModelAttribute("programTemplate") ProgramTemplate programTemplate) {
            programTemplateService.create(programTemplate);
            return "redirect:/p_temp_list";
    }

    @RequestMapping("/p_temp/{id}")
    public String singleProgramTemplate(Map<String, Object> map,
                                        @PathVariable("id") Long id) {
        ProgramTemplate pt =  programTemplateService.read(id);
        map.put("user", getPrincipal());
        map.put("programTemplate", pt);
        map.put("exerciseTemplate", new ExerciseTemplate());
        map.put("exerciseTemplateList", pt.getExerciseTemplateList());
        map.put("exerciseTemplateListAll", exerciseTemplateService.readAll());
        return "/p_temp";
    }

    @RequestMapping("/p_temp/{id}/edit_form")
    public String editFormSingleProgramTemplate(Map<String, Object> map,
                                                @PathVariable("id") Long id) {
        ProgramTemplate pt =  programTemplateService.read(id);
        map.put("user", getPrincipal());
        map.put("programTemplate", pt);
        map.put("exerciseTemplate", new ExerciseTemplate());
        map.put("exerciseTemplateList", pt.getExerciseTemplateList());
        map.put("exerciseTemplateListAll", exerciseTemplateService.readAll());
        map.put("edit", true);
        return "/p_temp";
    }

    @RequestMapping(value = "/p_temp/{id}/edit", method = RequestMethod.POST)
    public String editSingleProgramTemplate(@ModelAttribute("programTemplate") ProgramTemplate programTemplate,
                                            @PathVariable("id") Long id) {
            ProgramTemplate pt = programTemplateService.read(id);
            pt.setName(programTemplate.getName());
            pt.setDescription(programTemplate.getDescription());
            pt.setNote(programTemplate.getNote());
            programTemplateService.update(pt);
            return "redirect:/p_temp/" + id;
            //i think it would be better to get full programTemplate from jsp and update it
            //not find it by id and update
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
