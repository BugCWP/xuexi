package com.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class mysqlPool {
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/mymysql?serverTimezone=GMT";
    private static final String USER="root";
    private static final String PASS="302771918";
    private static ComboPooledDataSource cpds;
    static {
        cpds=new ComboPooledDataSource();
        try {
            cpds.setDriverClass(DRIVER);
            cpds.setJdbcUrl(URL);
            cpds.setUser(USER);
            cpds.setPassword(PASS);
            cpds.setMaxPoolSize(10);
            cpds.setMinPoolSize(2);
        }catch (PropertyVetoException e){
            e.printStackTrace();
        }
    }
    private mysqlPool(){

    }
    private static final mysqlPool INSTANCE=new mysqlPool();
    public static mysqlPool getInstance(){
        return INSTANCE;
    }
    public synchronized Connection getConnection(){
        Connection conn=null;
        try {
            conn=cpds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
