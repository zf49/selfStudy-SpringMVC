package com.kuang.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         // 放行：判断什么情况下登陆
        HttpSession session =request.getSession();
         //登陆页面放行
        if(request.getRequestURI().contains("gologin")){
          return true;
        }

//        说明我在提交登陆
        if(request.getRequestURI().contains("login")){
            return true;
        }

               //session中有userInfo
        //第一次登陆是没有session的
          if(session.getAttribute("userInfo")!= null){
             return true;

          }
          
        //判断什么情况下没有登陆，判断Session
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;




    }
}
