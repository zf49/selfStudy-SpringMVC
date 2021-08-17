package com.kuang.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

public class ControllerDemo implements Controller {

//只要实现controller接口那么这个就是一个控制器
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView modelAndView = new ModelAndView();
//        对象名称， 内容
        modelAndView.addObject("aaa","实现Controller接口");

        // 跳转到"test。jsp"文件
        modelAndView.setViewName("test");

        return modelAndView;
        
    }




}
