package com.example.javaspringbootdemo.controller;
import com.example.javaspringbootdemo.mapper.Usermapper;
import com.example.javaspringbootdemo.test.Student;
import com.example.javaspringbootdemo.test.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Slf4j
@Controller
@Tag(name = "测试", description = "测试")
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
    @ApiResponses({
       @ApiResponse(responseCode = "200", description = "测试成功"),
       @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
})
@Operation(summary = "请求用户数据测试接口")   //接口功能描述
    public User test(HttpServletRequest request){
       MDC.put("reqId", request.getSession().getId());
       log.info("用户访问了一次测试数据");
       return mapper.getUserById(1);
    }

    @GetMapping("/")
    public String register()
    {
        return "register";
    }

   @ResponseBody
    @PostMapping("/validtest")
    public String submit( @RequestParam @Length(min = 3) String username,  //使用@Length注解一步到位
                         @RequestParam @Length(min = 10) String password){
        if (username == null || password == null) {
        return "用户名或密码不能为空";
    }
        System.out.println(username.substring(3));
        System.out.println(password.substring(2, 10));
        return "请求成功!";
    }



}
