package com.gym.controller.profile;

import com.gym.controller.GenericController;
import com.gym.transientObject.PasswordHolder;
import com.gym.objects.User;
import com.gym.validator.EditPasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class ProfilePasswordController extends GenericController {

    @Autowired
    private EditPasswordValidator editPasswordValidator;

    @InitBinder("passwordHolder")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(editPasswordValidator);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/profile_edit_password", method = RequestMethod.GET)
    public String userEditPasswordForm(Map<String, Object> map) {
        map.put("user", getPrincipal());
        map.put("passwordHolder", new PasswordHolder());
        return "profile_edit_password";
    }

    @RequestMapping(value = "/profile_save_password", method = RequestMethod.POST)
    public String savePassword(@ModelAttribute("passwordHolder") @Validated PasswordHolder passwordHolder,
                               BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "profile_edit_password";
        } else {
            System.out.println("passwordHolder:"  + passwordHolder);
            User u = userService.read(getPrincipal().getId());
            System.out.println("u:" + u);
            u.setPassword(passwordEncoder.encode(passwordHolder.getNewPassword()));
            userService.update(u);
            return "redirect:/logout";
        }
    }
}
