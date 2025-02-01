package com.example.javaspringbootdemo.test;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
@Setter
public class Student {
        String name;
        int age;
}

