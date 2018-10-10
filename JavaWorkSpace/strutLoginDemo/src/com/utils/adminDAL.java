package com.utils;

import com.model.Page;
import com.model.adminModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class adminDAL {
    private DBUtil dbUtil=new DBUtil(mysqlPool.getInstance().getConnection());
    //增
    public boolean addAdmin(adminModel admin){
        String sql="insert into admininfo (uname,upass) values (?,?)";
        return updatePool(sql,admin);
    }
    //删
    public boolean delAdmin(adminModel admin){
        String sql="delete from admininfo where uname=? and upass=?";
        return updatePool(sql,admin);
    }
    //改
    public boolean updateAdmin(adminModel admin){
        String  sql="update admininfo set upass=? where uname=?";
        int res=0;
        Map<Integer,Object> parame=new HashMap<>();
        parame.put(1,admin.getUpass());
        parame.put(2,admin.getUname());
        res=dbUtil.ececuteUpdatePool(sql,parame);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }
    //查
    public List<adminModel> selectAdminlist(Page page){
        String sql="select * from admininfo limit ?,?";
        int pageStart=(page.getPageIndex()-1)*page.getPageSize();
        Map<Integer,Object> parame=new HashMap<>();
        parame.put(1,pageStart);
        parame.put(2,page.getPageSize());
        ResultSet res=dbUtil.executeQueryPool(sql,parame);
        List<adminModel> adminModels=new ArrayList<>();
        try {
            while (res.next()){
                adminModel admin=new adminModel(res.getString("uname"),res.getString("upass"));
                adminModels.add(admin);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return adminModels;
    }

    public int adminCount(){
        String sql="select count(*) from admininfo";
        ResultSet res=dbUtil.executeQueryPool(sql,null);
        int count=0;
        try {
            while (res.next()){
                count=res.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }

    public boolean selectAdmin(adminModel admin){
        String sql="select count(*) from admininfo where uname=? and upass=?";
        Map<Integer,Object> parame=new HashMap<>();
        parame.put(1,admin.getUname());
        parame.put(2,admin.getUpass());
        ResultSet res=dbUtil.executeQueryPool(sql,parame);
        int count=0;
        try {
            while (res.next()){
                count=res.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (count>0){
            return true;
        }else {
            return false;
        }
    }

    private boolean updatePool(String sql, adminModel admin){
        int res=0;
        Map<Integer,Object> parame=new HashMap<>();
        parame.put(1,admin.getUname());
        parame.put(2,admin.getUpass());
        res=dbUtil.ececuteUpdatePool(sql,parame);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }
}
