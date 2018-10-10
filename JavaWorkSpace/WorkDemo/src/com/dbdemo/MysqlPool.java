package com.dbdemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.*;

public class MysqlPool {
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
      private MysqlPool(){}
      private static final MysqlPool Instance=new MysqlPool();
      public static  MysqlPool getInstance(){
          return Instance;
      }
      public synchronized Connection getConnection(){
          Connection conn=null;
              try {
                  conn=cpds.getConnection();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
              return conn;
      }
}
