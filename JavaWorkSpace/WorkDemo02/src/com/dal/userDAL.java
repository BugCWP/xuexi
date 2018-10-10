package com.dal;

import com.Util.DBUtil;
import com.Util.mysqlPoolUtil;
import com.model.userModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class userDAL {
     DBUtil db=new DBUtil(mysqlPoolUtil.getInstance().getConnection());
    //查询是否存在用户
      public boolean selectUser(String name,String pass){
          boolean res=false;
          String sql="select * from workloginuser where uname=? and pass=?";
          Map<Integer,Object> params=new HashMap<>();
          params.put(1,name);
          params.put(2,pass);
          ResultSet resultSet=db.executeQueryPool(sql,params);
          try {
              while (resultSet.next()){
                  res=true;
              }
          }catch (SQLException e){
              e.printStackTrace();
          }
          return res;
      }
      //用户列表查询
    public List<userModel> userModelList(){
          String sql="select * from workdemo2user";
          ResultSet res=db.executeQueryPool(sql,null);
          List<userModel> userModels=new ArrayList<>();
          try {
              while (res.next()){
                  userModel user=new userModel();
                  user.setName(res.getString("uname"));
                  user.setPass(res.getString("pass"));
                  user.setLol(res.getString("lol"));
                  user.setTime(res.getString("utime"));
                  user.setIp(res.getString("ip"));
                  userModels.add(user);
              }
          }catch (SQLException e){
              e.printStackTrace();
          }
          return userModels;
    }
    //用户删除
    public boolean deleteUser(userModel user){
          String sql="delete from workdemo2user where uname=? and pass=? and lol=? and utime=? and ip=?";
          Map<Integer,Object> params=getUserParams(user);
          int res=db.ececuteUpdatePool(sql,params);
          if (res>0){
              return true;
          }else {
              return false;
          }
    }
    //用户修改
    public boolean updateUser(userModel user){
          String sql="update workdemo2user set uname=? ,pass=? ,lol=?, utime=?, ip=? where uname=?";
          Map<Integer,Object> params=getUserParams(user);
          params.put(6,user.getName());
          int res=db.ececuteUpdatePool(sql,params);
          if (res>0){
              return true;
          }else {
              return false;
          }
    }
    //存入用户
    public boolean insertUser(userModel user){
          String sql="insert into workdemo2user (uname,pass,lol,utime,ip) values(?,?,?,?,?)";
          Map<Integer,Object> params=getUserParams(user);
          int res=db.ececuteUpdatePool(sql,params);
        if (res>0){
            return true;
        }else {
            return false;
        }
    }
    private Map<Integer,Object> getUserParams(userModel user){
        Map<Integer,Object> params=new HashMap<>();
        params.put(1,user.getName());
        params.put(2,user.getPass());
        params.put(3,user.getLol());
        params.put(4,user.getTime());
        params.put(5,user.getIp());
        return params;
    }
}
