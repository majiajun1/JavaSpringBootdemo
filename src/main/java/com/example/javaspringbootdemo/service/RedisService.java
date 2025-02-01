package com.example.javaspringbootdemo.service;



//@Service
//public class RedisService {
//
//    @Resource
//    StringRedisTemplate template;
//
//
//
//    @PostConstruct
//    public void init(){
//        template.setEnableTransactionSupport(true);   //需要开启事务
//    }
//
//    @Transactional
//      public void test() {
//        // 开始事务
//        template.execute((RedisCallback<Object>) connection -> {
//            connection.multi();  // 开始事务
//
//            // 执行事务中的命令
//            connection.set("d".getBytes(), "xxxxx".getBytes());
//
//            // 提交事务
//            connection.exec();
//            return null;
//        });
//    }
//}