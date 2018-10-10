package com.lianxi;

import java.sql.*;
public class mysqlDemo {
    static final String JDBC_DEIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/mymysql";
    static final String USER="root";
    static final String PASS="302771918";
    public static void  main(String[] args){
        Connection conn=null;
        Statement stmt=null;
        try{
             Class.forName(JDBC_DEIVER);
             conn=DriverManager.getConnection(DB_URL,USER,PASS);
             stmt=conn.createStatement();
             String sql="SELECT * FROM user";
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
