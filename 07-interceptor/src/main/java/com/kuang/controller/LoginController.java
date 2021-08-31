package com.kuang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

     @RequestMapping("/login")
    public String login(HttpSession httpSession, String username, String pwd, Model model){
          // 登陆后把用户的信息存在session中

         httpSession.setAttribute("userInfo",username);
         model.addAttribute("userInfo",username);


         return "main";
    }

    @RequestMapping("/goOut")
    public String goOut(HttpSession httpSession){
        // 登陆后把用户的信息存在session中

          httpSession.removeAttribute("userInfo");
//            httpSession.invalidate();

        return "main";
    }



    @RequestMapping("/gologin")
    public String goLogin(){
         
        return "login";
    }

    @RequestMapping("/main")
    public String main(){
          return "main";
    }




}
