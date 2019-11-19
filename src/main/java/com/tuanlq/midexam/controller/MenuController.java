package com.tuanlq.midexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {
    @GetMapping("")
    public ModelAndView getFormMenu(){
        ModelAndView modelAndView = new ModelAndView("/menu");
        return modelAndView;
    }
}
