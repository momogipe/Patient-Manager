package com.manager.patient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Maincontroller {
    @GetMapping ("/index")
    public ModelAndView home () {
        return new ModelAndView("redirect:/index.html");
    }
}
