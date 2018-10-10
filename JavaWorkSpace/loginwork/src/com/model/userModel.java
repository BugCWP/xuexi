package com.model;

public class userModel {
    private String uname;
    private String ulol;
    private String uip;
    private String utime;

    public userModel(String uname, String ulol, String uip, String utime) {
        this.uname = uname;
        this.ulol = ulol;
        this.uip = uip;
        this.utime = utime;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUlol() {
        return ulol;
    }

    public void setUlol(String ulol) {
        this.ulol = ulol;
    }

    public String getUip() {
        return uip;
    }

    public void setUip(String uip) {
        this.uip = uip;
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime;
    }
}
