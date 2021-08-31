

# Spring MVC

https://blog.csdn.net/qq_33369905/article/details/106647319?spm=1001.2014.3001.5502

步骤：

1.  确定maven依赖，以及project structure的依赖
2. 确定视图层 .jsp文件
3. 配置dispatchServlet （web.xml）

```xml
<!--    配置dispatchServlet  这个是SpringMVC的核心  -->
        <servlet>
            <servlet-name>springmvc</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
<!--            DispatcherServlet 要绑定Spring的配置文件-->
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>classpath:springmvc-servlet.xml</param-value>
            </init-param>
            <load-on-startup>1</load-on-startup>
        </servlet>

<!--   /: 匹配所有请求，但不会去匹配jsp页面-->
<!--    /* ：匹配所有请求，包括jsp页面-->

        <servlet-mapping>
            <servlet-name>springmvc</servlet-name>
            <url-pattern>/</url-pattern>
        </servlet-mapping>

```

4. 绑定Spring 配置文件

   ![image-20210816170947817](/Users/chris/Library/Application Support/typora-user-images/image-20210816170947817.png)

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd">
   
   
   <!--       处理器映射器-->
              <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>
       
   <!--       处理器适配器-->
              <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>
   <!--       视图解析器-->
              <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="internalResourceViewResolver">
              <property name="prefix" value="/WEB_INF/jsp/"/>
              <property name="suffix" value=".jsp"/>
              </bean>
       
   
   </beans>
   ```

   5. controller

      ```java
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
      
      ```

      

   6. 在springmvc-servlet.xml中配置bean

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd">
   
   
   <!--       处理器映射器-->
              <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>
       
   <!--       处理器适配器-->
              <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>
   <!--       视图解析器-->
              <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="internalResourceViewResolver">
              <property name="prefix" value="/WEB_INF/jsp/"/>
              <property name="suffix" value=".jsp"/>
              </bean>
     
     
   <!--BeanNameUrlHandlerMapping:bean
   写完controller 配置这个bean
   -->
              <bean id ="/hello" class="com.kuang.controller.HelloController"></bean>
   
   </beans>
   
   ```

   ## Step

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
            version="4.0">
   
   
   
   
       <!--1.注册servlet-->
       <servlet>
           <servlet-name>SpringMVC</servlet-name>
           <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
           <!--通过初始化参数指定SpringMVC配置文件的位置，进行关联-->
           <init-param>
               <param-name>contextConfigLocation</param-name>
               <param-value>classpath:springmvc-servlet.xml</param-value>
           </init-param>
           <!-- 启动顺序，数字越小，启动越早 -->
           <load-on-startup>1</load-on-startup>
       </servlet>
   
   
       <!--所有请求都会被springmvc拦截 -->
       <servlet-mapping>
           <servlet-name>SpringMVC</servlet-name>
           <url-pattern>/</url-pattern>
       </servlet-mapping>
     
     
       <!--乱码 -->
   
   
     <filter>
           <filter-name>encoding</filter-name>
           <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
           <init-param>
               <param-name>encoding</param-name>
               <param-value>utf-8</param-value>
           </init-param>
       </filter>
       <filter-mapping>
           <filter-name>encoding</filter-name>
           <url-pattern>/*</url-pattern>
       </filter-mapping>
   
   
   </web-app>
   ```

   1. Web.xml

   2. Springmvc-servlet.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:context="http://www.springframework.org/schema/context"
          xmlns:mvc="http://www.springframework.org/schema/mvc"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd
          http://www.springframework.org/schema/context
          https://www.springframework.org/schema/context/spring-context.xsd
          http://www.springframework.org/schema/mvc
          https://www.springframework.org/schema/mvc/spring-mvc.xsd">
   
   
       <!-- 自动扫描包，让指定包下的注解生效,由IOC容器统一管理 -->
       <context:component-scan base-package="com.kuang.controller"/>
       <!-- 让Spring MVC不处理静态资源 -->
       <mvc:default-servlet-handler />
       <!--
       支持mvc注解驱动
           在spring中一般采用@RequestMapping注解来完成映射关系
           要想使@RequestMapping注解生效
           必须向上下文中注册DefaultAnnotationHandlerMapping
           和一个AnnotationMethodHandlerAdapter实例
           这两个实例分别在类级别和方法级别处理。
           而annotation-driven配置帮助我们自动完成上述两个实例的注入。
        -->
       <mvc:annotation-driven />
   
   
       <!-- 视图解析器 -->
       <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"
             id="internalResourceViewResolver">
           <!-- 前缀 -->
           <property name="prefix" value="/WEB-INF/jsp/" />
           <!-- 后缀 -->
           <property name="suffix" value=".jsp" />
       </bean>
   
   
   </beans>
   ```

   3. Controller

      ```java
      @Controller
      @RequestMapping("/HelloController")
      public class HelloController {
       
       
         //真实访问地址 : 项目名/HelloController/hello
         @RequestMapping("/hello")
         public String sayHello(Model model){
             //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
             model.addAttribute("msg","hello,SpringMVC");
             //web-inf/jsp/hello.jsp
             return "hello";
        }
      }
      
      ```

      




在参数前加上

```java
@Controller
@RequestMapping("/user")

public class UserController {

@GetMapping("/t1")
public String test1(@RequestParam("name") String name, Model model){
    System.out.println(name);

    model.addAttribute("msg",name);


        return "user";

    }


}
```



当前端接受的是一个对象？

```java
//     对象？
@GetMapping("/t2")
//http://localhost:8080/user/t1?id=1&name=chirs&age=25
public String test2(User user, Model model) {
    System.out.println(user);

    return "user";
}
/*执行流程
* 1。 接受前端用户传递的参数，判断参数名字，假设名字直接在方法上，可以直接使用
* 2。 假设传递的是一个对象，匹配USer对象中的字段名，如果可以匹配，则成功，反之失败
*
*
* */
```

----

JSON

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.0-rc1</version>
</dependency>
```

```java
@Controller
//@RestController
public class UserController {

    @RequestMapping("/j1")
    @ResponseBody//    它就不会走视图解析器，会直接返回字符串
    public String test1() throws JsonProcessingException {

       //jackson中又一个 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("Chris",20,"nan");

        String s = mapper.writeValueAsString(user);
        
        return s;
    }
    
}
```

```xml
    <!--解决json 乱码配置-->

<mvc:annotation-driven>
    <mvc:message-converters register-defaults="true">
        <bean class="org.springframework.http.converter.StringHttpMessageConverter">
            <constructor-arg value="UTF-8"/>
        </bean>
        <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
            <property name="objectMapper">
                <bean class="org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean">
                    <property name="failOnEmptyBeans" value="false"/>
                </bean>
            </property>
        </bean>
    </mvc:message-converters>
</mvc:annotation-driven>
```

fast json



```java
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
```

```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.78</version>
</dependency>
```

---

拦截器

实现HandleerInterceptpr接口

拦截器就是AOP的一个具体实现

```java
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
```

--

upload and download

实现文件上传，表单的method必须为post，并将其enctype设置为multipart/form-data

倒包：

```xml
<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.4</version>
</dependency>
<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
</dependency>
```



applicationContext

```xml
<bean id="multipartResolver"
      class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
    <!--defaultEncoding：请求的编码格式必须和用户JSP的编码一致，以便正确读取表单中的内容。
        uploadTempDir:文件上传过程中的临时目录，上传完成后，临时文件会自动删除
        maxUploadSize:设置文件上传大小上限（单位为字节） -->
    <property name="defaultEncoding" value="UTF-8" />
    <property name="maxUploadSize" value="102400000" />
    <!-- uploadTempDir可以不做设置，有默认的路径，上传完毕会临时文件会自动被清理掉 -->
</bean>
```

2 different ways 

```java
package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class MyTest {


   //@RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
    //批量上传CommonsMultipartFile则为数组即可
    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file , HttpServletRequest request) throws IOException {

        //获取文件名 : file.getOriginalFilename();
        String uploadFileName = file.getOriginalFilename();

        //如果文件名为空，直接回到首页！
        if ("".equals(uploadFileName)){
            return "redirect:/index.jsp";
        }
        System.out.println("上传文件名 : "+uploadFileName);

        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        //如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址："+realPath);

        InputStream is = file.getInputStream(); //文件输入流
        OutputStream os = new FileOutputStream(new File(realPath,uploadFileName)); //文件输出流

        //读取写出
        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();
        return "redirect:/index.jsp";
    }




    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("/upload2")
    public String  fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {

        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        //上传文件地址
        System.out.println("上传文件保存地址："+realPath);

        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(new File(realPath +"/"+ file.getOriginalFilename()));

        return "redirect:/index.jsp";
    }




    
}
```

```html
<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2021/9/1
  Time: 上午12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

     <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">

       <input type="file" name="file">
       <input type="submit" value="upload">

     </form>


  
  </body>
</html>
```

----------

downLoad

```java
  @RequestMapping("/download")
    public String downloads(HttpServletResponse response , HttpServletRequest request) throws Exception{

        //要下载的图片地址
        String  path = request.getServletContext().getRealPath("/upload");
        System.out.println(path);
//        TODO：只改这一个位置
        String  fileName = "A2-report-ZhifangWang.docx";

        //1、设置response 响应头
        response.reset(); //设置页面不缓存,清空buffer
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType("multipart/form-data"); //二进制传输数据
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path,fileName);
        //2、 读取文件--输入流
        InputStream input=new FileInputStream(file);
        //3、 写出文件--输出流
        OutputStream out = response.getOutputStream();

        byte[] buff =new byte[1024];
        int index=0;
        //4、执行 写出操作
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        return "ok";
    }@RequestMapping(value="/download")
public String downloads(HttpServletResponse response ,HttpServletRequest request) throws Exception{
    //要下载的图片地址
    String  path = request.getServletContext().getRealPath("/upload");
    String  fileName = "基础语法.jpg";
 
    //1、设置response 响应头
    response.reset(); //设置页面不缓存,清空buffer
    response.setCharacterEncoding("UTF-8"); //字符编码
    response.setContentType("multipart/form-data"); //二进制传输数据
    //设置响应头
    response.setHeader("Content-Disposition",
            "attachment;fileName="+URLEncoder.encode(fileName, "UTF-8"));
 
    File file = new File(path,fileName);
    //2、 读取文件--输入流
    InputStream input=new FileInputStream(file);
    //3、 写出文件--输出流
    OutputStream out = response.getOutputStream();
 
    byte[] buff =new byte[1024];
    int index=0;
    //4、执行 写出操作
    while((index= input.read(buff))!= -1){
        out.write(buff, 0, index);
        out.flush();
    }
    out.close();
    input.close();
    return null;
}
```



最暴力：

前端加连接

```html
<a href="${pageContext.request.contextPath}/statics/A2-report-ZhifangWang.docx">下载文件</a>
```



