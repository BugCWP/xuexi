package com.cwp.dao;

import com.cwp.entity.Page;
import com.cwp.entity.Permission;

import java.util.List;

public interface PermissionDao {
    //添加社区
    boolean addPermission(Permission permission);
    //修改社区
    boolean updatePermission(Permission permission);
    //删除社区
    boolean deletePermission(Permission permission);
    //查询单个社区
    Permission findPermission(Permission permission);
    //查询社区列表
    List<Permission> listPermission(Permission permission, Page page);
    //查询社区数量
    Long findTotalPermission(Permission permission);
    //查询所有社区列表
    List<Permission> allListPermission(Permission permission);
    //查询社区是否存在
    boolean isExisr(Permission permission);
}
