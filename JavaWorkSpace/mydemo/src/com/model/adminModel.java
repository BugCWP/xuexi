package com.model;

public class adminModel {
    private String uname;
    private String upass;
    private String uid;
    private String utime;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime;
    }

    public adminModel(String uname, String upass, String uid, String utime) {
        this.uname = uname;
        this.upass = upass;
        this.uid = uid;
        this.utime = utime;
    }
    public adminModel(String uname,String upass){
        this.uname = uname;
        this.upass = upass;
    }
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }
}
