package com.gym.controller;

import com.gym.objects.Owner;
import com.gym.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by anni0913 on 28.09.2016.
 */

@Controller
@SessionAttributes("owner")
@Scope("session")
public class InnerController {

    @Autowired
    OwnerService ownerService;

    @ModelAttribute("owner")
    public Owner populateOwner() {
        return new Owner();
    }

    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/users";
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String welcome(Map<String, Object> map) {
        map.put("owner", new Owner());
        map.put("ownerList", ownerService.readAll());
        return "users";
    }

    @RequestMapping(value = "/home/{id}", method = RequestMethod.GET)
    public String singleProgram(@PathVariable("id") Long id,
                                Map<String, Object> map) {
        map.put("owner", ownerService.read(id));
        return "home";
    }

    @RequestMapping("/users/delete/{id}")
    public String deleteProgram(@PathVariable("id") Long id) {
        ownerService.delete(ownerService.read(id));
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addProgram(@ModelAttribute("owner") Owner owner) {
        ownerService.create(owner);
        return "redirect:/users";
    }
}
