package com.dbdemo;

import com.filter.LoginFilter;
import com.model.LoginUserModel;
import com.model.UserModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pageDAL {
    public static int pageIndex=1;
    private static int pageSize=10;
    static DBUtil db=new DBUtil();

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public static List<LoginUserModel> getloginUserModels(){
        String sql="select * from loginuser limit ?,?";
        Integer countPage=(pageIndex-1)*pageSize;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,countPage);
        Integer size=pageSize;
        map.put(2,size);
        ResultSet res=db.executeQuery2(sql,map);
        List<LoginUserModel> loginUserModels=new ArrayList<>();
        System.out.println("getloginUserModels");
        try {
            while (res.next()){
                String uName=res.getString("uName");
                String uPwd=res.getString("uPwd");
                LoginUserModel loginUser=new LoginUserModel(uName,uPwd);
                loginUserModels.add(loginUser);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return loginUserModels;
    }
}
