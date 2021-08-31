package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
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

    @RequestMapping("/a2")
    public List<User> a2(){


        List<User> list = new ArrayList();

        //添加数据
        list.add(new User("niubi1",20,"男"));
        list.add(new User("niubi2",30,"女"));
        list.add(new User("niubi3",50,"男"));
        list.add(new User("niubi4",60,"男"));
        
        return list;

    }





        @RequestMapping("/a3")
    public String a3(String name, String pwd){
                String msg= "";
           if(name!=null){
               if("admin".equals(name)){
                  msg = "ok";
               }else {
                   msg="failed";
               }

           }

            if(pwd!=null){
                if("admin".equals(pwd)){
                    msg = "ok";
                }else {
                    msg="pwd failed";
                }

            }
            return msg;
    }


}
