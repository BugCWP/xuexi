package com.huaiwei.lianxi;

public class text2 {
    public static void main(String[] args) {
        String str="sdkajhsgihellojahdkshg";
        int numj=0;
        int nums=0;
        char [] c1=str.toCharArray();
        for(int i=0;i<c1.length;i++){
            if(c1[i]=='j'){
                numj++;
                System.out.println("j的位置："+i);
            }
            if(c1[i]=='s'){
                nums++;
                System.out.println("s的位置:"+i);
            }
        }
        System.out.println(numj);
        System.out.println(nums);
        String h=str.substring(str.indexOf("hello"),str.indexOf("hello")+5);
        System.out.println(h.toUpperCase());
    }
}
