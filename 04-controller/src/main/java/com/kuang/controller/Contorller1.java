package com.kuang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c1")
public class Contorller1 {

    @RequestMapping("/t1")
    public String test1(Model model){

        model.addAttribute("qq","contoller1adasdadasdasd");

        return "admin/qwe";
    }


}
