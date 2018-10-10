package com.lianxi;

import java.sql.ResultSet;

public class text5 extends DBUtil{
    public static void main(String[] args) {
        String sql1="select *from user";
        DBUtil db=new DBUtil();
        ResultSet rs= db.query(sql1);
        System.out.println(rs);
    }
}
