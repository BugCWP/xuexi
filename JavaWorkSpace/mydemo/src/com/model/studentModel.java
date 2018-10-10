package com.model;

public class studentModel {
    private int id;
    private String sname;
    private String snumber;
    private String sgrade;
    private String sclass;

    public studentModel(int id) {
        this.id = id;
    }

    public studentModel(String sname, String snumber, String sgrade, String sclass) {
        this.sname = sname;
        this.snumber = snumber;
        this.sgrade = sgrade;
        this.sclass = sclass;
    }

    public studentModel(int id, String sname, String snumber, String sgrade, String sclass) {
        this.id = id;
        this.sname = sname;
        this.snumber = snumber;
        this.sgrade = sgrade;
        this.sclass = sclass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getSgrade() {
        return sgrade;
    }

    public void setSgrade(String sgrade) {
        this.sgrade = sgrade;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }
}
