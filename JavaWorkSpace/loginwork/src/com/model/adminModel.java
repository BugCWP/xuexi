package com.model;

public class adminModel {
    private String uname;
    private String upass;

    public adminModel(String uname, String upass) {
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
