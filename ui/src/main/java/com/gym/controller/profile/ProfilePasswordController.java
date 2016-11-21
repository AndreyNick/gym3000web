package com.gym.controller.profile;

import com.gym.controller.GenericController;
import com.gym.objects.User;
import com.gym.validator.EditPasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

    @InitBinder("user")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(editPasswordValidator);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/profile_edit_password", method = RequestMethod.GET)
    public String userEditPasswordForm(Map<String, Object> map) {
        User user = getPrincipal();
        user.setPassword(null);
        user.setConfirmPassword(null);
        user.setPreviousPassword(null);
        map.put("user", user);
        return "profile_edit_password";
    }

    @RequestMapping(value = "/profile_save_password", method = RequestMethod.POST)
    public String savePassword(@ModelAttribute("user") User user,
                               BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "profile_edit_password";
        } else {
            User u = userService.read(getPrincipal().getId());
            u.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.update(u);
            return "redirect:/logout";
        }
    }
}
