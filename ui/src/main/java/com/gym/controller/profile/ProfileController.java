package com.gym.controller.profile;

import com.gym.controller.GenericController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ProfileController extends GenericController {

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String user(Map<String, Object> map) {
        map.put("user", getPrincipal());
        return "profile";
    }

}
