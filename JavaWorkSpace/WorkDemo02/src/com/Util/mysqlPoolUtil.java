package com.Util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.net.PortUnreachableException;
import java.sql.*;
public class mysqlPoolUtil {
    private static ComboPooledDataSource cpds;
    static DBUtil dbUtil=new DBUtil();
    static {
        cpds=new ComboPooledDataSource();
        try {
            cpds.setDriverClass(dbUtil.getDRIVER());
            cpds.setJdbcUrl(dbUtil.getURL());
            cpds.setUser(dbUtil.getUSER());
            cpds.setPassword(dbUtil.getPASS());
            cpds.setMaxPoolSize(10);
            cpds.setMinPoolSize(2);
        }catch (PropertyVetoException e){
            e.printStackTrace();
        }
    }
    private mysqlPoolUtil(){

    }
    private static final mysqlPoolUtil INSTANCE=new mysqlPoolUtil();
    public static mysqlPoolUtil getInstance(){
        return INSTANCE;
    }
    public synchronized  Connection getConnection(){
        Connection conn=null;
        try {
            conn=cpds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
