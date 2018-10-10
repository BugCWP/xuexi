package com.model;

public class userModel {
    private String name;
    private String pass;
    private String lol;
    private String time;
    private String ip;
    public userModel(){

    }
     public userModel(String name,String pass,String lol,String time,String ip){
         this.name=name;
         this.pass=pass;
         this.lol=lol;
         this.time=time;
         this.ip=ip;
     }
    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setLol(String lol) {
        this.lol = lol;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getLol() {
        return lol;
    }

    public String getTime() {
        return time;
    }

    public String getIp() {
        return ip;
    }
}
