package com.lianxi;

public class text {
    int c=0;
    double c1=0;
    boolean c2=false;
    public text(int a,int b){
        if(a>b){
            c=a;
        }else {
            c=b;
        }
        System.out.println(c);
    }
    public  text(double a,double b,double i){
        c1=a*b*i;
        System.out.println(c1);
    }
    public  text(String str1,String str2) {
        if (str1.equals(str2)) {
            c2 = true;
        } else {
            c2 = false;
        }
        System.out.println(c2);
    }
    public static void main(String[] args) {
        text t1=new text(2,3);
        text t2=new text("djsakdjsak","jdadja");
        text t3=new text(2.3,43.3,43.6);
    }
}
