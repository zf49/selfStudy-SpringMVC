package com.kuang.controller;


import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")

public class UserController {

@GetMapping("/t1")
public String test1(@RequestParam("username") String name, Model model){
    System.out.println(name);

    model.addAttribute("msg",name);
        return "user";
    }


//     对象？
@GetMapping("/t2")


/*执行流程
* 1。 接受前端用户传递的参数，判断参数名字，假设名字直接在方法上，可以直接使用
* 2。 假设传递的是一个对象，匹配USer对象中的字段名，如果可以匹配，则成功，反之失败
*
*
* */
//http://localhost:8080/user/t1?id=1&name=chirs&age=25
public String test2(User user, Model model) {
    System.out.println(user);

    return "user";
}

   @GetMapping("/t3")
    public String test3(ModelMap modelMap) {
    

        return "user";
    }
    }
