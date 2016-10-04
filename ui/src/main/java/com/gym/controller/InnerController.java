package com.gym.controller;

import com.gym.objects.User;
import com.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@SessionAttributes("user")
@Scope("session")
public class InnerController {

    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public User populateUser() {
        return new User();
    }

    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/users";
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String welcome(Map<String, Object> map) {
        map.put("user", new User());
        map.put("userList", userService.readAll());
        return "users";
    }

    @RequestMapping(value = "/home/{id}", method = RequestMethod.GET)
    public String singleProgram(@PathVariable("id") Long id,
                                Map<String, Object> map) {
        map.put("user", userService.read(id));
        return "home";
    }

    @RequestMapping("/users/delete/{id}")
    public String deleteProgram(@PathVariable("id") Long id) {
        userService.delete(userService.read(id));
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addProgram(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/{userId}/edit_form")
    public String editFormUser(Map<String, Object> map,
                               @PathVariable("userId") Long userId) {
        map.put("user", new User());
        map.put("userList", userService.readAll());
        map.put("edit_user", userId);
        return "users";
    }

    @RequestMapping(value = "/users/{id}/edit", method = RequestMethod.POST)
    public String editSingleExercise(@ModelAttribute("user") User user,
                                     @PathVariable("id") Long id) {
        User u = userService.read(id);
        u.setName(user.getName());
        userService.update(u);
        return "redirect:/users";
    }
}
