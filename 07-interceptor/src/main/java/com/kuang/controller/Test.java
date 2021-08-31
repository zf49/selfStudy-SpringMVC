package com.kuang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @RequestMapping("/t1")
    public String teste1(Model model){
        System.out.println("Test()被执行了");

        return "OKOKOKOKOKOk";
    }




}
