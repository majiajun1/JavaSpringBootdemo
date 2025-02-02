package com.example.javaspringbootdemo.controller;

import com.example.javaspringbootdemo.mapper.UsersMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RegisterController {

    @Resource
    JavaMailSender mailSender;

    @Resource
    UsersMapper mapper;

    @PostMapping("/code")
    public String code(HttpSession session, @RequestParam String email){
        Random rand = new Random();

        String code =   String.valueOf(rand.nextInt(900000) + 100000);

        session.setAttribute("code",code);
        session.setAttribute("email",email);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("验证码");
        message.setText("验证码是："+code+"有效时间三分钟");
        message.setTo(email);
          //邮件发送者，这里要与配置文件中的保持一致
        message.setFrom("masonjj@foxmail.com");
        mailSender.send(message);
        return "发送成功";


    }

    @PostMapping("/register")
    public String register(@RequestParam String username,@RequestParam String email,
                           @RequestParam String code,@RequestParam String password,HttpSession session)
    {


        Object sessionCode = String.valueOf(session.getAttribute("code"));

        String sessionEmail = (String) session.getAttribute("email");

        if(sessionCode==null||!sessionEmail.equals(email))
        {
            return "请先获取验证码";
        }

        if(!sessionCode.equals(code))
        {
            return "验证码不正确";
        }

        mapper.createUsers(username,email,password);
        return "注册成功";
    }
}
