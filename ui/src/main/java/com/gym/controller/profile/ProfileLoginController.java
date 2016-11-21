package com.gym.controller.profile;

import com.gym.controller.GenericController;
import com.gym.objects.User;
import com.gym.validator.EditLoginValidator;
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
public class ProfileLoginController extends GenericController {

    @Autowired
    private EditLoginValidator editLoginValidator;

    @InitBinder("user")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(editLoginValidator);
    }

    @RequestMapping(value = "/profile_edit_login", method = RequestMethod.GET)
    public String userEditLoginForm(Map<String, Object> map) {
        map.put("user", getPrincipal());
        return "profile_edit_login";
    }

    @RequestMapping(value = "/profile_save_login", method = RequestMethod.POST)
    public String saveLogin(@ModelAttribute("user") @Validated User user,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "profile_edit_login";
        } else {
            User u = userService.read(getPrincipal().getId());
            System.out.println("login:"+ user.getLogin());
            u.setLogin(user.getLogin());
            userService.update(u);
            return "redirect:/logout";
        }
    }
}
