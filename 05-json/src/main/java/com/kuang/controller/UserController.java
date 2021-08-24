package com.kuang.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuang.pojo.User;
import com.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController      // 只会返回字符串
public class UserController {

    @RequestMapping("/j1")
//    @ResponseBody//    它就不会走视图解析器，会直接返回字符串
    public String test1() throws JsonProcessingException {

       //jackson中又一个 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("Chris",20,"nan");

        String s = mapper.writeValueAsString(user);

        return s;
    }
    
    @RequestMapping("/j2")
//    @ResponseBody//    它就不会走视图解析器，会直接返回字符串
    public String test2() throws JsonProcessingException {



        //jackson中又一个 ObjectMapper
//        ObjectMapper mapper = new ObjectMapper();


        List<User> list = new ArrayList();
        User user1 = new User("Chris1",20,"nan");
        User user2 = new User("Chris2",20,"nan");
        User user3 = new User("Chris3",20,"nan");
        User user4 = new User("Chris4",20,"nan");

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

//        String s = mapper.writeValueAsString(list);

        return Utils.getJson(list);
    }


    @RequestMapping("/j3")
//    @ResponseBody//    它就不会走视图解析器，会直接返回字符串
    public String test3() throws JsonProcessingException {



//        //jackson中又一个 ObjectMapper
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);
//
//
////        默认时间戳
        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        String format = simpleDateFormat.format(date);
//
//        mapper.setDateFormat(simpleDateFormat);
//
//        String s = mapper.writeValueAsString(date);




        return Utils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }



    @RequestMapping("/j4")
//    @ResponseBody//    它就不会走视图解析器，会直接返回字符串
    public String test4() throws JsonProcessingException {

        List<User> list = new ArrayList();
        User user1 = new User("Chris1",20,"nan");
        User user2 = new User("Chris2",20,"nan");
        User user3 = new User("Chris3",20,"nan");
        User user4 = new User("Chris4",20,"nan");

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        String s = JSON.toJSONString(list);
        return s;

    }




}
