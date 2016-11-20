package com.gym.controller;

import com.gym.objects.Role;
import com.gym.objects.User;
import com.gym.validator.EditNameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class InnerController extends GenericController {

    @Autowired
    private EditNameValidator editNameValidator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @InitBinder("user")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(editNameValidator);
    }

    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/home";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String user(Map<String, Object> map) {
        map.put("user", getPrincipal());
        return "profile";
    }

    @RequestMapping(value = "/profile_edit_name", method = RequestMethod.GET)
    public String userEditNameForm(Map<String, Object> map) {
        map.put("user", getPrincipal());
        return "profile_edit_name";
    }

    @RequestMapping(value = "/profile_edit_login", method = RequestMethod.GET)
    public String userEditLoginForm(Map<String, Object> map) {
        map.put("user", getPrincipal());
        return "profile_edit_login";
    }

    @RequestMapping(value = "/profile_edit_password", method = RequestMethod.GET)
    public String userEditPasswordForm(Map<String, Object> map) {
        System.out.println(getPrincipal());
        map.put("user", getPrincipal());
        return "profile_edit_password";
    }

    @RequestMapping(value = "/profile_save_name", method = RequestMethod.POST)
    public String saveName(@ModelAttribute("user") @Validated User user,
                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("error: " + bindingResult.getAllErrors());
            return "profile_edit_name";
        } else {
            User u = userService.read(getPrincipal().getId());
            u.setName(user.getName());
            userService.update(u);
            return "redirect:/profile";
        }
    }

    @RequestMapping(value = "/profile_save_login", method = RequestMethod.POST)
    public String saveLogin(@ModelAttribute("user") User user,
                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("error: " + bindingResult.getAllErrors());
            return "profile_edit_login";
        } else {
            User u = userService.read(getPrincipal().getId());
            System.out.println("login:"+ user.getLogin());
            u.setLogin(user.getLogin());
            userService.update(u);
            return "redirect:/logout";
        }
    }

    @RequestMapping(value = "/profile_save_password", method = RequestMethod.POST)
    public String savePassword(@ModelAttribute("user") User user,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("error: " + bindingResult.getAllErrors());
            return "profile_edit_password";
        } else {
            User u = userService.read(getPrincipal().getId());
            u.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.update(u);
            return "redirect:/logout";
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String welcome(Map<String, Object> map) {
        map.put("user", getPrincipal());
        map.put("userList", userService.readAll());
        map.put("role", new Role());
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

    @RequestMapping(value = "/users/{userId}/edit_form")
    public String editFormUser(Map<String, Object> map,
                               @PathVariable("userId") Long userId) {
        map.put("user", getPrincipal());
        map.put("userList", userService.readAll());
        map.put("edit_user", userId);
        return "users";
    }

    @RequestMapping(value = "/users/{id}/edit", method = RequestMethod.POST)
    public String editSingleExercise(@ModelAttribute("user") User user,
                                     @PathVariable("id") Long id) {
        User u = userService.read(id);
        u.setEnabled(user.isEnabled());
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
        return "redirect:/login?logout";
    }
}
