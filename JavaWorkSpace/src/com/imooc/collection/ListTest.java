package com.imooc.collection;

import java.util.ArrayList;
import java.util.List;
/*
* 备选课程
* */
public class ListTest {
    /*
    * 用于存放备选课程
    * */
    public List courseToSelect;
    public  ListTest(){
        this.courseToSelect=new ArrayList();
    }
    public void testAdd(){
        Course c1=new Course("1","数据结构");
        courseToSelect.add(c1);
    }
}
