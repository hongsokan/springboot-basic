package com.example.basic.admintlte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminlteController {

    @GetMapping("")
    public ModelAndView adminlte() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/dashboard");
        return modelAndView;
    }
}
