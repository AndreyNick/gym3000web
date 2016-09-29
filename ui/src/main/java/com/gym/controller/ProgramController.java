package com.gym.controller;

import com.gym.objects.Exercise;
import com.gym.objects.ExerciseTemplate;
import com.gym.objects.Owner;
import com.gym.objects.Program;
import com.gym.service.ExerciseService;
import com.gym.service.ExerciseTemplateService;
import com.gym.service.OwnerService;
import com.gym.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@SessionAttributes("owner")
@Scope("session")
public class ProgramController {

    @Autowired
    ProgramService programService;

    @Autowired
    ExerciseTemplateService exerciseTemplateService;

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    OwnerService ownerService;

    @RequestMapping(value = "/prog_list", method = RequestMethod.GET)
    public String printPrograms(Map<String, Object> map,
                                HttpSession session) {
        Owner owner = (Owner)session.getAttribute("owner");
        map.put("program", new Program());
        map.put("programList", programService.getProgramsByOwnerId(owner.getId()));
        return "prog_list";
    }

    @RequestMapping("/prog_list/delete/{id}")
    public String deleteProgram(@PathVariable("id") Long id) {
        programService.delete(programService.read(id));
        return "redirect:/prog_list";
    }

    @RequestMapping(value = "/prog_list/add", method = RequestMethod.POST)
    public String addProgram(@ModelAttribute("program") Program program,
                             HttpSession session) {
        Owner owner = (Owner)session.getAttribute("owner");
        program.setOwner(ownerService.read(owner.getId()));
        programService.create(program);
        return "redirect:/prog_list";
    }

    @RequestMapping(value = "/prog/{id}", method = RequestMethod.GET)
    public String singleProgram(Map<String, Object> map, @PathVariable("id") Long id) {
        Program p =  programService.read(id);
        map.put("program", p);
        map.put("exercise", new Exercise());
        map.put("exerciseTemplate", new ExerciseTemplate());
        map.put("exerciseList", exerciseService.getExercisesByProgramId(p.getId()));
        map.put("exerciseTemplateListAll", exerciseTemplateService.readAll());
        return "/prog";
    }

    @RequestMapping("/prog/{id}/edit_form")
    public String editFormSingleProgram(Map<String, Object> map, @PathVariable("id") Long id) {
        Program p =  programService.read(id);
        map.put("program", p);
        map.put("exercise", new Exercise());
        map.put("exerciseTemplate", new ExerciseTemplate());
        map.put("exerciseList", exerciseService.getExercisesByProgramId(p.getId()));
        map.put("exerciseTemplateListAll", exerciseTemplateService.readAll());
        map.put("edit", true);
        return "/prog";
    }

    @RequestMapping(value = "/prog/{id}/edit", method = RequestMethod.POST)
    public String editSingleProgramTemplate(@ModelAttribute("programTemplate") /*@Validated*/ Program program,
                                            @PathVariable("id") Long id,
                                            BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("ERROR.");
            return "redirect:/prog/" + id + "/edit_form";
        } else {
            Program p = programService.read(id);
            p.setName(program.getName());
            p.setDescription(program.getDescription());
            p.setNote(program.getNote());
            p.setDate(program.getDate());
            programService.update(p);
            return "redirect:/prog/" + id;
            //i think it would be better to get full program from jsp and update it
            //not find it by id and update
            //todo: think about it
        }
    }

    @RequestMapping(value = "/prog/{programId}/add/{exerciseTemplateId}")
    public String addExerciseToProgram(
            @PathVariable("programId") Long programId,
            @PathVariable("exerciseTemplateId") Long exerciseTemplateId) {
        Program p = programService.read(programId);
        ExerciseTemplate et = exerciseTemplateService.read(exerciseTemplateId);
        Exercise exercise = new Exercise(p, et, et.getName(),et.getDescription(), et.getNote());
        p.addExercise(exercise);
        exerciseService.create(exercise);
        programService.update(p);
        return "redirect:/prog/" + programId;
    }

    @RequestMapping(value = "/prog/{programId}/delete/{exerciseId}")
    public String deleteExerciseFromProgram(
            @PathVariable("programId") Long programId,
            @PathVariable("exerciseId") Long exerciseId) {
        Program p = programService.read(programId);
        p.deleteExercise(exerciseService.read(exerciseId));
        programService.update(p);
        exerciseService.delete(exerciseService.read(exerciseId));
        return "redirect:/prog/" + programId;
    }
}
