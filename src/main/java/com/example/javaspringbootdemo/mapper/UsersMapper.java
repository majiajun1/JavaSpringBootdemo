package com.example.javaspringbootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.javaspringbootdemo.test.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UsersMapper   {
      @Insert("insert into users(username, email, password) values(#{username}, #{email}, #{password})")
      void createUsers(@Param("username") String username, @Param("email") String email, @Param("password") String password);



}
