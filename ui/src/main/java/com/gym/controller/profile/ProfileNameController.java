package com.gym.controller.profile;

import com.gym.controller.GenericController;
import com.gym.objects.User;
import com.gym.validator.EditNameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ProfileNameController extends GenericController {

    @Autowired
    private EditNameValidator editNameValidator;

    @InitBinder("user")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(editNameValidator);
    }

    @RequestMapping(value = "/profile_edit_name", method = RequestMethod.GET)
    public String userEditNameForm(Map<String, Object> map) {
        User user = userService.readByLogin(getPrincipal().getLogin());
        map.put("user", user);
        map.put("username", user.getName());
        return "profile_edit_name";
    }


    @RequestMapping(value = "/profile_save_name", method = RequestMethod.POST)
    public String saveName(@ModelAttribute("user") @Validated User user,
                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "profile_edit_name";
        } else {
            User u = userService.read(getPrincipal().getId());
            u.setName(user.getName());
            userService.update(u);
            return "redirect:/profile";
        }
    }
}

