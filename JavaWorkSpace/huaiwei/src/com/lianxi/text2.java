package com.lianxi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class text2 {
    public static void main(String[] args) {
        List<String> aList= Arrays.asList("acvsd","abc","dsad","abc");
        ArrayList<String> aStr=new ArrayList<String>();
        for(String str:aList){
            if(str!="abc"){
                aStr.add(str);
            }
        }
        System.out.println(aStr);
    }
}
