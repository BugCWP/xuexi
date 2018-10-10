package com.lianxi;

import java.util.Random;

public class text3 {
    public static void main(String[] args) {

        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");
        t1.start();
        t2.start();
    }

}
class MyThread extends Thread{
     int[] arr={10,5,20,50,100,200,500,800,2,80,300};
     @Override
     public void run(){
         Random random=new Random();
         int i=random.nextInt(11);
         System.out.println(Thread.currentThread().getName()+"又产生了一个"+arr[i]+"元大奖");
     }
}
