package com.kuang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloPractice {


    @RequestMapping("/practice")
    public String practice(Model model){

        model.addAttribute("msg","练习MVC");
        return "hello";
    }




}
