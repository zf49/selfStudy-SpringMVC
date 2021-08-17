package com.kuang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testConbtroller {

    @RequestMapping("/qwe")
    public String test(Model model){

        model.addAttribute("aaa","skjudhkajsdahkjdhajk");

          return "aaa";


    }






}
