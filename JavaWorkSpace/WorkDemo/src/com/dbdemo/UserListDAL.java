package com.dbdemo;

import com.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserListDAL {
    DBUtil db=new DBUtil();
    //登陆储存
    public boolean inputUser(UserModel user){
         String sql="insert into userlist (uname,id,lol,utime) values (?,?,?,?)";
        Map<Integer,String> pamare=new HashMap<>();
        pamare.put(1,user.getName());
        pamare.put(2,user.getIp());
        pamare.put(3,user.getLol());
        pamare.put(4,user.getTime());
        int res=db.executeUpdate(sql,pamare);
        if (res>0){
            return true;
        }else {
            return false;
        }
    }
    //获取列表
    public List<UserModel> getUserList(){
        List<UserModel> userlist=new ArrayList<>();
        String sql="select * from userlist";
        Map<Integer,String> pamare=new HashMap<>();
        ResultSet res=db.executeQuery(sql,pamare);
        try {
            while (res.next()){
                String name=res.getString("uname");
                String id=res.getString("id");
                String lol=res.getString("lol");
                String time=res.getString("utime");
                UserModel user=new UserModel(name,id,time,lol);
                userlist.add(user);
            }
        }catch (SQLException e){
             e.printStackTrace();
        }
        return userlist;
    }
    //离开删除
    public boolean deletUser(UserModel user){
        String sql="delete from userlist where uname=? and id=? and lol=? and utime=?";
        Map<Integer,String> pamare=new HashMap<>();
        pamare.put(1,user.getName());
        pamare.put(2,user.getIp());
        pamare.put(3,user.getLol());
        pamare.put(4,user.getTime());
        int res=db.executeUpdate(sql,pamare);
        if (res>0){
            return true;
        }else {
            return false;
        }
    }
}
