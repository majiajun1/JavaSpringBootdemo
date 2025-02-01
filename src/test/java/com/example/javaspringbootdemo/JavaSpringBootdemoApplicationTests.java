package com.example.javaspringbootdemo;


//import com.example.javaspringbootdemo.service.RedisService;
import com.example.javaspringbootdemo.mapper.Usermapper;
import com.example.javaspringbootdemo.test.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import com.example.javaspringbootdemo.test.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootTest
class JavaSpringBootdemoApplicationTests {
//      @Resource
//    StringRedisTemplate template;
//
//      @Resource
//      RedisService service;
//
//    @Test
//   void contextLoads() {
//        ValueOperations<String, String> operations = template.opsForValue();
//        operations.set("c", "xxxxx");   //设置值
//        System.out.println(operations.get("c"));   //获取值
//
//        template.delete("c");    //删除键
//        System.out.println(template.hasKey("c"));   //判断是否包含键
//    }
//
//    @Test
//    void testRedis() {
//        service.test();
//    }
        @Test
            void contextLoads() {
            System.out.println(new Student());
        }

         @Autowired
         Usermapper mapper;

   @Test
    public void test2(){
       System.out.println(mapper.getUserById(1));
   }

}
