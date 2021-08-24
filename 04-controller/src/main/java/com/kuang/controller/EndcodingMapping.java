package com.kuang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EndcodingMapping {


    @PostMapping("/e/t1")
    public String teste1(String name,Model model){

        model.addAttribute("msg",name);


        return "test";
    }



}
