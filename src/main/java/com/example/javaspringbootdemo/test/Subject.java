package com.example.javaspringbootdemo.test;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subjects")   //学科信息表
public class Subject {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    @Id
    int cid;

    @Column(name = "name")
    String name;



    @Column(name = "time")
    int time;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tid")   //存储教师ID的字段，和一对一是一样的，也会当前表中创个外键
    Teacher teacher;
}