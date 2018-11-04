package com.cwp.entity;

import javax.persistence.*;
import java.io.Serializable;

/*
*权限表
 */
@Entity
@Table(name = "permission")
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Long permissionId;
    @Column(name = "permission_name")
    private String permissionName;
    @Column(name = "permission_level")
    private String permissionLevel;
    @Column(name = "permission_delete")
    private int permissionDelete;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public int getPermissionDelete() {
        return permissionDelete;
    }

    public void setPermissionDelete(int permissionDelete) {
        this.permissionDelete = permissionDelete;
    }
}
