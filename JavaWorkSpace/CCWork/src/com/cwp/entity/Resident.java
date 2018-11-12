package com.cwp.entity;



import javax.persistence.*;
import java.io.Serializable;
/*
 *居民实体类
 *
 */

@Entity
@Table(name = "resident_table")
public class Resident implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resident_id",nullable = false)
    private Long residentId;
    @Column(name = "resident_account")
    private String residentAccount;
    @Column(name = "resident_password")
    private String residentPassword;
    @Column(name = "resident_name")
    private String residentName;
    @Column(name = "resident_community")
    private String residentCommunity;
    @Column(name = "resident_phone")
    private String residentPhone;
    @Column(name = "resident_adress")
    private String residentAdress;
    @Column(name = "resident_avatar")
    private String residentAvatar;
    @Column(name = "resident_age")
    private String residentAge;
    @Column(name = "resident_permission")
    private Long residentPermission;
    @Column(name = "resident_delete")
    private int residentDelete;

    public int getResidentDelete() {
        return residentDelete;
    }

    public void setResidentDelete(int residentDelete) {
        this.residentDelete = residentDelete;
    }

    public Long getResidentId() {
        return residentId;
    }

    public void setResidentId(Long residentId) {
        this.residentId = residentId;
    }

    public String getResidentAccount() {
        return residentAccount;
    }

    public void setResidentAccount(String residentAccount) {
        this.residentAccount = residentAccount;
    }

    public String getResidentPassword() {
        return residentPassword;
    }

    public void setResidentPassword(String residentPassword) {
        this.residentPassword = residentPassword;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getResidentCommunity() {
        return residentCommunity;
    }

    public void setResidentCommunity(String residentCommunity) {
        this.residentCommunity = residentCommunity;
    }

    public String getResidentPhone() {
        return residentPhone;
    }

    public void setResidentPhone(String residentPhone) {
        this.residentPhone = residentPhone;
    }

    public String getResidentAdress() {
        return residentAdress;
    }

    public void setResidentAdress(String residentAdress) {
        this.residentAdress = residentAdress;
    }

    public String getResidentAvatar() {
        return residentAvatar;
    }

    public void setResidentAvatar(String residentAvatar) {
        this.residentAvatar = residentAvatar;
    }

    public Long getResidentPermission() {
        return residentPermission;
    }

    public void setResidentPermission(Long resdentPermission) {
        this.residentPermission = resdentPermission;
    }

    public String getResidentAge() {
        return residentAge;
    }

    public void setResidentAge(String residentAge) {
        this.residentAge = residentAge;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "residentId=" + residentId +
                ", residentAccount='" + residentAccount + '\'' +
                ", residentPassword='" + residentPassword + '\'' +
                ", residentName='" + residentName + '\'' +
                ", residentCommunity='" + residentCommunity + '\'' +
                ", residentPhone='" + residentPhone + '\'' +
                ", residentAdress='" + residentAdress + '\'' +
                ", residentAvatar='" + residentAvatar + '\'' +
                ", residentAge='" + residentAge + '\'' +
                ", resdentPermission=" + residentPermission +
                ", residentDelete=" + residentDelete +
                '}';
    }
}
