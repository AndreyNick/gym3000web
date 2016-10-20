package com.gym.controller;

import com.gym.objects.User;
import com.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class InnerController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/home";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Map<String, Object> map) {
        map.put("user", new User());
        return "user";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String welcome(Map<String, Object> map) {
        map.put("user", getPrincipal());
        map.put("userList", userService.readAll());
        return "users";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(Map<String, Object> map) {
        map.put("user", getPrincipal());
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

    @RequestMapping(value = "/error403", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "error403";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

    private User getPrincipal(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return userService.readByName(((UserDetails)principal).getUsername());
        } else {
            return null;
        }
    }
}
