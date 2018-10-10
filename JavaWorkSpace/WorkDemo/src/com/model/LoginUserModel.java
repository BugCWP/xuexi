package com.model;

public class LoginUserModel {
    private String uName;
    private String uPwd;
    public LoginUserModel(String uName,String uPwd){
        this.uName=uName;
        this.uPwd=uPwd;
    }
    public String getuName() {
        return uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }
}
