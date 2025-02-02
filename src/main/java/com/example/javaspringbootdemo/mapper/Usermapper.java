package com.example.javaspringbootdemo.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.javaspringbootdemo.test.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Usermapper {

    @Select("select * from user where id=#{id}")
    User getUserById(int id);


}
