package com.carstation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carstation {
    public static void main(String[] args) {
           List<book> books=new ArrayList<>();
           book b1=new book("论语",111);
           book b2=new book("十万个为什么",222);
           book b3=new book("世说新语",333);
           books.add(b1);
           books.add(b2);
           books.add(b3);
           Scanner in=new Scanner(System.in);
           Scanner str=new Scanner(System.in);
           Carstation c=new Carstation();
          while (true){
               System.out.println("输入命令：1-按照名称查找图书 2-按照序号查找图书");
               int key1=in.nextInt();
               if(key1==1){
                    System.out.println("请输入图书名称：");
                    String string=str.nextLine();
                    System.out.println(c.findBookByName(string,books));
               }else if(key1==2){
                     System.out.println("请输入图书序号：");
                     int i=in.nextInt();
                     System.out.println(c.findBookById(i,books));
               }else {
                   System.out.println("输入的命令错误！请根据提示输入正确数字命令！");
               }
           }
    }
    public  String findBookByName(String name,List<book> books){
        String ret="";
        for (book b:books) {
            if (b.getBookName().equals(name)) {
                ret= "book:" + b.getBookName();
                break;
            } else {
                ret= "图书不存在";
            }
        }
        return ret;
    }
    public String findBookById(int id,List<book> books){
        String ret="";
        for (book b:books) {
            if (b.getBookId() == id) {
                ret= "book:" + b.getBookName();
                break;
            } else {
                ret= "图书不存在";
            }
        }
        return ret;
    }
}
