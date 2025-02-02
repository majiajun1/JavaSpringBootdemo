package com.example.javaspringbootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.javaspringbootdemo.test.User2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface Users2Mapper extends BaseMapper<User2> {

}
