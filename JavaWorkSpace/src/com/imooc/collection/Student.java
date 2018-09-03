package com.imooc.collection;

import java.util.HashSet;
import java.util.Set;
/*
* 学生类
* */
public class Student {
    public String Id;
    public  String Name;
    public Set course;
    public Student(String Id,String Name){
        this.Id=Id;
        this.Name=Name;
        this.course=new HashSet();
    }
}
