package com.huaiwei.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindUser {
    DBUtil db=new DBUtil();
    //查询用户和密码是否正确
    public boolean finduser(String uname,String pwd){
        String sql="select * from loginuser where uName=? and uPwd=?";
        Map<Integer,String> pamare=new HashMap<>();
        pamare.put(1,uname);
        pamare.put(2,pwd);
        ResultSet res=db.executeQuery(sql,pamare);
        int i=0;
        try {
            while (res.next()){
                System.out.println(res.getString("uName"));
                i++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    //查询用户和密码列表
    public ResultSet getUserList(){
        String sql="select * from loginuser";
        Map<Integer,String> pamare=new HashMap<>();
        ResultSet res=db.executeQuery(sql,pamare);
        return res;
    }
    //删除用户操作
    public boolean deleteUser(String name,String pwd){
        String sql="delete * from loginuser where uName=? and uPwd=?";
        Map<Integer,String> pamare=new HashMap<>();
        pamare.put(1,name);
        pamare.put(2,pwd);
        int i= db.executeUpdate(sql,pamare);
        db.closeAll();
        if (i>0){
            return true;
        }else {
            return  false;
        }
    }
}
