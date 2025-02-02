package com.example.javaspringbootdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.javaspringbootdemo.test.User2;
import org.springframework.stereotype.Service;

@Service
public interface User2Service extends IService<User2> {
  	//除了继承模版，我们也可以把它当成普通Service添加自己需要的方法
}