package com.Util;

import java.sql.*;
import java.util.Map;

public class DBUtil {
    private final String DRIVER="com.mysql.cj.jdbc.Driver";
    private final String URL="jdbc:mysql://localhost:3306/mymysql?serverTimezone=GMT";
    private final String USER="root";
    private final String PASS="302771918";
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet res=null;

    public String getDRIVER() {
        return DRIVER;
    }

    public String getURL() {
        return URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASS() {
        return PASS;
    }

    public DBUtil(){

    }
    public DBUtil(Connection conn){
        this.conn=conn;
    }
    private boolean getConnection(){
        try {
            Class.forName(DRIVER);
            conn=DriverManager.getConnection(URL,USER,PASS);
            return true;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    private void initParams(PreparedStatement ps, Map<Integer,Object> params) throws SQLException{
        if (params!=null){
            for (int i=1;i<params.size();i++){
                ps.setObject(i,params.get(i));
            }
        }
    }
    public ResultSet executeQuery(String sql,Map<Integer,Object> params){
        if (getConnection()){
            try {
                ps=conn.prepareStatement(sql);
                initParams(ps,params);
                res=ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return res;
        }else {
            return null;
        }
    }
    public ResultSet executeQueryPool(String sql,Map<Integer,Object> params){
        if (conn!=null){
            try {
                ps=conn.prepareStatement(sql);
                initParams(ps,params);
                res=ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return res;
        }else {
            return null;
        }
    }
    public int ececuteUpdate(String sql,Map<Integer,Object> params){
        int i=0;
        if (getConnection()){
            try {
                ps=conn.prepareStatement(sql);
                initParams(ps,params);
                i=ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }
    public int ececuteUpdatePool(String sql,Map<Integer,Object> params){
        int i=0;
        if (conn!=null){
            try {
                ps=conn.prepareStatement(sql);
                initParams(ps,params);
                i=ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }
    public boolean closeAll(){
        try{
            if (res!=null){
                res.close();
            }
            if (ps!=null){
                ps.close();
            }
            if (conn!=null){
                conn.close();
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
