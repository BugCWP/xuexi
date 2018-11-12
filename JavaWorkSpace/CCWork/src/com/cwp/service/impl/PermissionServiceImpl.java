package com.cwp.service.impl;

import com.cwp.dao.PermissionDao;
import com.cwp.entity.Page;
import com.cwp.entity.Permission;
import com.cwp.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;


    @Override
    public boolean addPermission(Permission permission) {
        return permissionDao.addPermission(permission);
    }

    @Override
    public boolean deletePermission(Permission permission) {
        return permissionDao.deletePermission(permission);
    }

    @Override
    public boolean updatePermission(Permission permission) {
        return permissionDao.updatePermission(permission);
    }

    @Override
    public List<Permission> listPermission(Permission permission, Page page) {
        return permissionDao.listPermission(permission,page);
    }

    @Override
    public List<Permission> allListPermission(Permission permission) {
        return permissionDao.allListPermission(permission);
    }

    @Override
    public Permission findPermission(Permission permission) {
        return permissionDao.findPermission(permission);
    }
}
