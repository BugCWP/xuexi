package com.model;

public class UserModel {
    public UserModel(String name,String ip,String time,String lol){
        this.name=name;
        this.ip=ip;
        this.time=time;
        this.lol=lol;
    }
    private String name;
    private String ip;
    private String time;
    private String lol;

    public void setName(String name) {
        this.name = name;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLol(String lol) {
        this.lol = lol;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public String getTime() {
        return time;
    }

    public String getLol() {
        return lol;
    }
}
