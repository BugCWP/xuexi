package com.lianxi;

import java.util.*;

public class text4 {
    public static void main(String[] args) {
         text4 t=new text4();
         t.listStr();
    }
    public void listStr(){
        System.out.println("请输入需要去重的集合,以，作为间隔，退出请输入-1：");
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        if(!str.equals("-1")) {
            List<String> lis = Arrays.asList(str.split(","));
            Set ser=new HashSet();
            List newlist=new ArrayList<>();
            for(Iterator iter=lis.iterator();iter.hasNext();){
                  Object element=iter.next();
                  if(ser.add(element))
                      newlist.add(element);
            }
            for(Object s:newlist){
                System.out.print(s+",");
            }
            System.out.println("\n");
            text4 t=new text4();
            t.listStr();
        }
    }
}
