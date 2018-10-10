package com.day12;

import java.sql.*;
import java.util.Map;

public class DBUtil {
    private final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DBURL = "jdbc:mysql://localhost:3306/mymysql?serverTimezone=GMT";
    private final String USER = "root";
    private final String PASS = "302771918";
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet res = null;

    private boolean getConnection() {
        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, USER, PASS);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //查询
    public ResultSet executeQuery(String sql, Map<Integer, String> params) {
        if (getConnection()) {
            try {
                ps = conn.prepareStatement(sql);
                initParams(ps, params);
                res = ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            return null;
        }
        return res;
    }
    //修改
    public int executeUpdate(String sql,Map<Integer,String> params){
        int i=0;
        if(getConnection()){
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
    private void initParams(PreparedStatement ps, Map<Integer, String> params) throws SQLException {
        if (params != null) {
            for (int i = 1; i <= params.size(); i++) {
                ps.setString(i, params.get(i));
            }
        }
    }

    public boolean closeAll(){
        try{
            if(res!=null){
                res.close();
            }
            if(ps!=null){
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
