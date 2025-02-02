package com.example.javaspringbootdemo.test;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data

@TableName("users2")
public class User2 {
    @TableId(type = IdType.AUTO)   //对应的主键
    int id;
    @TableField("username")   //对应的字段
    String name;
    @TableField("email")
    String email;
    @TableField("password")
    String password;


}
