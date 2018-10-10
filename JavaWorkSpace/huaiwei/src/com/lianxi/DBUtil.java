package com.lianxi;

import java.sql.*;
public class DBUtil {
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet res=null;
    private PreparedStatement ps=null;
    private final String DBDRIVER="com.mysql.cj.jdbc.Driver";
    private final String DBURL="jdbc:mysql://localhost:3306/mymysql?serverTimezone=GMT";
    private final String USER="root";
    private final String PASS="302771918";
    private boolean getConnection(){
        try {
            Class.forName(DBDRIVER);
            conn=DriverManager.getConnection(DBURL,USER,PASS);
            return true;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
    protected ResultSet query(String sql){
        if(getConnection()){
            try {
                  stmt=conn.createStatement();
                  res=stmt.executeQuery(sql);
                  return res;
            }catch (SQLException e){
                e.printStackTrace();
                return  null;
            }
        }else {
            return  null;
        }
    }
    protected int update(String sql){
        if(getConnection()){
            try {
                stmt=conn.createStatement();
                int flag=stmt.executeUpdate(sql);
                return flag;
            }catch (SQLException e){
                e.printStackTrace();
                return -1;
            }catch (Exception e){
                e.printStackTrace();
                return -1;
            }
        }else {
            return -1;
        }
    }
    protected boolean closeAll(){
        try {
            if(res!=null){
                res.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            if(conn!=null){
                conn.close();
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
