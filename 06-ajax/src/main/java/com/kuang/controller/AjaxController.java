package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AjaxController {

          @RequestMapping("/t1")
          public String test(){

              return "hello";

          }
        @RequestMapping("/a1")
    public void  a1(String name, HttpServletResponse response) throws IOException {
            System.out.println("a1: para=>" + name);

              if("chris".equals(name)){
                 response.getWriter().println("true");
                  
              } else{
                  response.getWriter().println("false");
              }
        }

    
}
