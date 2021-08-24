package com.kuang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller   // controller 代表这个类会被spring接管，
// 该类中所有的方法，如果返回值是String，且有具体的页面可以跳转
//那么就会被视图解析器解析
public class testConbtroller {

    @RequestMapping("/qwe")
    public String test1(Model model){

        model.addAttribute("aaa","test1");
           // 去寻找/WEB_INF/jsp/aaa.jsp
        
          return "aaa";
    }

    @RequestMapping("/asd")
    public String test2(Model model){

        model.addAttribute("aaa","test2");
        // 去寻找/WEB_INF/jsp/aaa.jsp

        return "aaa";
    }

}
