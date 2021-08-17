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

      

   4. 