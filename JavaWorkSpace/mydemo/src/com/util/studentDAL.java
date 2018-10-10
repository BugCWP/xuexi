package com.util;

import com.model.Page;
import com.model.studentModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class studentDAL {
    private DBUtil dbUtil=new DBUtil(mysqlPool.getInstance().getConnection());
    //增
    public boolean addStudent(studentModel student){
        String sql="insert into studeninfo (sname,sgrade,snumber,sclass) values (?,?,?,?)";
        return updatePool(sql,student);
    }
    //删
    public boolean delStudent(studentModel student){
        String sql="delete from studeninfo where id=?";
        int res=0;
        Map<Integer,Object> parame=new HashMap<>();
        parame.put(1,student.getId());
        res=dbUtil.ececuteUpdatePool(sql,parame);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }
    //改
    public boolean updateStudent(studentModel student){
        String  sql="update studeninfo set sname=?,sgrade=?,snumber=?,sclass=? where id=?";
        int res=0;
        Map<Integer,Object> parame=new HashMap<>();
        parame.put(1,student.getSname());
        parame.put(2,student.getSgrade());
        parame.put(3,student.getSnumber());
        parame.put(4,student.getSclass());
        parame.put(5,student.getId());
        res=dbUtil.ececuteUpdatePool(sql,parame);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }
    //查
    public List<studentModel> selectStudent(Page page){
        String sql="select * from studeninfo limit ?,?";
        int pageStart=(page.getPageIndex()-1)*page.getPageSize();
        Map<Integer,Object> parame=new HashMap<>();
        parame.put(1,pageStart);
        parame.put(2,page.getPageSize());
        ResultSet res=dbUtil.executeQueryPool(sql,parame);
        List<studentModel> studentModels=new ArrayList<>();
        try {
            while (res.next()){
                studentModel student=new studentModel(res.getInt("id"),res.getString("sname"),res.getString("snumber"),res.getString("sgrade"),res.getString("sclass"));
                studentModels.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return studentModels;
    }

    public int studentCount(){
        String sql="select count(*) from studeninfo";
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

//    public boolean selectStudent(studentModel student){
//        String sql="select count(*) from admininfo where uname=? and upass=?";
//        Map<Integer,Object> parame=new HashMap<>();
//        parame.put(1,admin.getUname());
//        parame.put(2,admin.getUpass());
//        ResultSet res=dbUtil.executeQueryPool(sql,parame);
//        int count=0;
//        try {
//            while (res.next()){
//                count=res.getInt(1);
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        if (count>0){
//            return true;
//        }else {
//            return false;
//        }
//    }

    private boolean updatePool(String sql, studentModel student){
        int res=0;
        Map<Integer,Object> parame=new HashMap<>();
        parame.put(1,student.getSname());
        parame.put(2,student.getSgrade());
        parame.put(3,student.getSnumber());
        parame.put(4,student.getSclass());
        res=dbUtil.ececuteUpdatePool(sql,parame);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }
}
