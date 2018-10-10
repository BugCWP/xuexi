package com.lianxi;

import java.lang.reflect.Array;
import java.util.*;

public class text1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        char[] ch=str.toCharArray();
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        for (char c:ch){
            Integer i=map.get(c);
            if(null==i){
                map.put(c,1);
            }else {
                i++;
                map.put(c,i);
            }
        }
        Set<Character> m=map.keySet();
        for(Character ca:m) {
            System.out.print(ca +":"+ map.get(ca)+"\t");
        }
    }
}
