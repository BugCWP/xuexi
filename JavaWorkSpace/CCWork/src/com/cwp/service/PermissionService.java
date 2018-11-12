package com.cwp.service;

import com.cwp.entity.Page;
import com.cwp.entity.Permission;

import java.util.List;

public interface PermissionService {
    //添加权限
    boolean addPermission(Permission permission);
    //删除权限
    boolean deletePermission(Permission permission);
    //修改权限
    boolean updatePermission(Permission permission);
    //返回权限队列
    List<Permission> listPermission(Permission permission, Page page);
    //返回所有队列
    List<Permission> allListPermission(Permission permission);
    //返回权限单条信息
    Permission findPermission(Permission permission);
}
