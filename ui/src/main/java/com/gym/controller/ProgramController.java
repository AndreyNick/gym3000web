package com.gym.controller;

import com.gym.objects.Program;
import com.gym.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ProgramController {

    @Autowired
    ProgramService programService;

    @RequestMapping(value = "/prog_list")
    public String printPrograms(Map<String, Object> map) {
        map.put("program", new Program());
        map.put("programList", programService.readAll());
        return "prog_list";
    }

    @RequestMapping("/prog/delete/{id}")
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
}
