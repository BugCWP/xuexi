package com.cwp.dao;

import com.cwp.entity.Page;
import com.cwp.entity.Permission;

import java.util.List;

public interface PermissionDao {
    //添加社区
    boolean addCommunity(Permission permission);
    //修改社区
    boolean updateCommunity(Permission permission);
    //删除社区
    boolean deleteCommunity(Permission permission);
    //查询单个社区
    Permission findCommunity(Permission permission);
    //查询社区列表
    List<Permission> listCommunity(Permission permission, Page page);
    //查询社区数量
    Long findTotalCommunity(Permission permission);
    //查询社区是否存在
    boolean isExisr(Permission permission);
}
