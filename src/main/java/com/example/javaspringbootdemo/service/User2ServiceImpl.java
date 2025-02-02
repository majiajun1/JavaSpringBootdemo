package com.example.javaspringbootdemo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.javaspringbootdemo.mapper.Users2Mapper;
import com.example.javaspringbootdemo.test.User2;
import org.springframework.stereotype.Service;

@Service   //需要继承ServiceImpl才能实现那些默认的CRUD方法
public class User2ServiceImpl extends ServiceImpl<Users2Mapper, User2> implements User2Service {

}