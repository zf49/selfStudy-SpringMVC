package com.kuang.controller;


import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {



    @RequestMapping(value = "/hello")
      public String hello(@NonNull Model model){

          model.addAttribute("msg","Hxkjcjksdhakjsdnajksdasdasdasdasd");
         return "hello";  // 会被视图解析器处理

      }


}
