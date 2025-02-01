package com.example.javaspringbootdemo.test;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    int id;
    String username;
    String password;
    String role;
}
