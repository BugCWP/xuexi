package com.huaiwei.lianxi;

public class text1 {
    public static void main(String[] args) {
        for(int i=100;i<=999;i++){
            double sum=Math.pow(i%10,3)+Math.pow((i-i%10)%100/10,3)+Math.pow(i/100,3);
            if(sum==i){
                System.out.println(sum);
            }
        }
    }
}
