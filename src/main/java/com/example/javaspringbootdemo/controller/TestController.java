package com.example.javaspringbootdemo.controller;
import com.example.javaspringbootdemo.mapper.Usermapper;
import com.example.javaspringbootdemo.test.Student;
import com.example.javaspringbootdemo.test.User;
import jakarta.annotation.Resource;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
public class TestController {
//    @ResponseBody
//    @RequestMapping("/")
//    public Student index() {
//        Student student = new Student();
//        student.setAge(10);
//        student.setName("sdasd");
//        System.out.println(student);
//        return student;
//    }

//
// @GetMapping("/login")
//    public String login() {
//     return "login";
// }

    @Autowired
    Usermapper mapper;

    @ResponseBody
    @GetMapping("/test")
    public User test(HttpServletRequest request){
       MDC.put("reqId", request.getSession().getId());
       log.info("用户访问了一次测试数据");
       return mapper.getUserById(1);
    }

}
