package com.gym.controller;

import com.gym.stub.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by anni0913 on 23.12.2014.
 */

@Controller
public class ProgramController {

    /*@Autowired
    private ProgramService programService;
*/

    @RequestMapping(value = "/")
    public String root() {
        return "programs";
    }

    @RequestMapping(value = "/programs", method = RequestMethod.GET)
    public String allPayments(Model model) {
        model.addAttribute("programs", /*programService.getAll()*/"test");
        return "programs";
    }


}
