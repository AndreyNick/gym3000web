package com.gym.controller;

import com.gym.objects.ProgramTemplate;
import com.gym.service.ProgramTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ProgramTemplateController {

    @Autowired
    ProgramTemplateService programTemplateService;


    @RequestMapping(value = "/p_temp")
    public String programTemplateList(Map<String, Object> map) {
        map.put("programTemplate", new ProgramTemplate());
        map.put("programTemplateList", programTemplateService.readAll());
        return "p_temp";
    }

    @RequestMapping("/p_temp/delete/{id}")
    public String deleteProgramTemplate(@PathVariable("id") Long id) {
        programTemplateService.delete(programTemplateService.read(id));
        return "redirect:/p_temp";
    }

    @RequestMapping(value = "/p_temp/add", method = RequestMethod.POST)
    public String addProgramTemplate(@ModelAttribute("programTemplate") ProgramTemplate programTemplate,
                             BindingResult result) {
        programTemplateService.create(programTemplate);
        return "redirect:/p_temp";
    }
}
