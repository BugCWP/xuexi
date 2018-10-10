package com.day12;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class work01 {
    public static void main(String[] args) {
        String sql="select * from user where id=?";
        Map<Integer,String> pamare=new HashMap<>();
        pamare.put(1,"1");
        DBUtil db=new DBUtil();
        ResultSet res=db.executeQuery(sql,pamare);
        try {
            while (res.next()){
                System.out.println(res.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
