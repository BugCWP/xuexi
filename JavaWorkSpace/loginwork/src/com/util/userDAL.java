package com.util;

import com.model.userModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class userDAL {
    private DBUtil dbUtil=new DBUtil(mysqlPool.getInstance().getConnection());
    //增
    public boolean adduser(userModel user){
       // System.out.println(user.getUname()+user.getUlol()+user.getUip()+user.getUtime());
        String sql="insert into userinfo (uname,ulol,uip,utime) values (?,?,?,?)";
        return UpdatePool(sql,user);
    }
    //删
    public boolean deluser(userModel user){
        String sql="delete from userinfo where uname=? and ulol=? and uip=? and utime=?";
        return UpdatePool(sql,user);
    }
    //改
    public boolean updateuser(userModel user){
        String sql="update userinfo set uname=?,ulol=? where uip=?,utime=?";
        return UpdatePool(sql,user);
    }
    //查
    public List<userModel> selectuser(){
        List<userModel> userModels=new ArrayList<>();
        String sql="select * from userinfo";
        ResultSet resultSet=dbUtil.executeQueryPool(sql,null);
        try {
            while (resultSet.next()){
                userModel user=new userModel(resultSet.getString("uname"),resultSet.getString("ulol"),resultSet.getString("uip"),resultSet.getString("utime"));
                userModels.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userModels;
    }

    private boolean UpdatePool(String sql,userModel user){
        int res=0;
        Map<Integer,Object> pamare=new HashMap<>();
        pamare.put(1,user.getUname());
        pamare.put(2,user.getUlol());
        pamare.put(3,user.getUip());
        pamare.put(4,user.getUtime());
        res=dbUtil.ececuteUpdatePool(sql,pamare);
        if (res>0){
            return true;
        }else{
            return false;
        }
    }

}
