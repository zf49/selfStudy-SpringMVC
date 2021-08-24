package com.kuang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestfullContorller {


    //  原来的：http://localhost:8080/add?a=1&b=2
   // restful：  http://localhost:8080/a/b
             @GetMapping  ("/add/{a}/{b}")
           public String test1(Model model, @PathVariable String a, @PathVariable int b){
                 String res =a + b;


                 model.addAttribute("qq",res);

               return "admin/qwe";
           }

    @PostMapping  ("/add/{a}/{b}")
    public String test2(Model model, @PathVariable String a, @PathVariable int b){
        String res =a + b;


        model.addAttribute("qq",res);

        return "admin/qwe";
    }

}
