package com.kuang.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        // 业务代码和跳转全部在此完成

        //业务代码
        String result = "helloSoring MVC!!!!!!!!!";

        modelAndView.addObject("msg",result);

        //跳转
        // 想跳转到哪个jsp就写哪个jsp页面的名字
         modelAndView.setViewName("test");

        
        return modelAndView;

    }




}
