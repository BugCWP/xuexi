package com.dbdemo;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class LoginYanZhen {
    public boolean login(String name,String pwd){
        boolean OK=false;
        DBUtil db=new DBUtil(MysqlPool.getInstance().getConnection());
        String sql="select * from loginuser where uName=? and uPwd=?";
        Map<Integer,String> map=new HashMap<>();
        ResultSet res=db.executeQuery(sql,map);
        try {
            while (res.next()){
                OK=true;
            }
        }catch (Exception e){
            e.printStackTrace();;
        }
        return OK;
    }
}
