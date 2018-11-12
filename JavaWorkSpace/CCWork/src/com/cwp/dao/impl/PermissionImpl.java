package com.cwp.dao.impl;

import com.cwp.dao.PermissionDao;
import com.cwp.entity.Page;
import com.cwp.entity.Permission;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PermissionImpl implements PermissionDao{
       @Autowired
       private SessionFactory sessionFactory;

    @Override
    public boolean addPermission(Permission permission) {
        Session s=sessionFactory.getCurrentSession();
        permission.setPermissionDelete(1);
        s.save(permission);
        return true;
    }

    @Override
    public boolean updatePermission(Permission permission) {
        Session s=sessionFactory.getCurrentSession();
        s.update(permission);
        return true;
    }

    @Override
    public boolean deletePermission(Permission permission) {
        Session s=sessionFactory.getCurrentSession();
        Long permissionId=permission.getPermissionId();
        String permissionName=permission.getPermissionName();
        String permissionLevel=permission.getPermissionLevel();
        Permission p=new Permission();
        if (permissionId!=null&&!"".equals(permissionId)){
            p=s.get(Permission.class,permission.getPermissionId());
        }
        else if(permissionName!=null&&!"".equals(permissionName)){
            p=s.get(Permission.class,permission.getPermissionName());
        }
        else if(permissionLevel!=null&&!"".equals(permissionLevel)){
            p=s.get(Permission.class,permission.getPermissionLevel());
        }
        p.setPermissionDelete(0);
        s.update(p);
        return false;
    }

    @Override
    public Permission findPermission(Permission permission) {
        Session s=sessionFactory.getCurrentSession();
        Long permissionId=permission.getPermissionId();
        String permissionName=permission.getPermissionName();
        Permission p=new Permission();
        if (permissionId!=null&&!"".equals(permissionId)){
            p=s.get(Permission.class,permission.getPermissionId());
        }
        else if(permissionName!=null&&!"".equals(permissionName)){
            p=s.get(Permission.class,permission.getPermissionName());
        }
        return p;
    }

    @Override
    public List<Permission> listPermission(Permission permission, Page page) {
        Session s=sessionFactory.getCurrentSession();
        Long permissionId=permission.getPermissionId();
        String permissionName=permission.getPermissionName();
        String permissionLevel=permission.getPermissionLevel();
        StringBuffer hql=new StringBuffer("from Permission where 1=1");
        if (permissionId!=null&&!"".equals(permissionId)){
           hql.append(" and permissionId= :permissionId");
        }
       if(permissionName!=null&&!"".equals(permissionName)){
            hql.append(" and permissionName= :permissionName");
        }
       if(permissionLevel!=null&&!"".equals(permissionLevel)){
            hql.append(" and permissionLevel = :permissionLevel");
        }
        hql.append(" and permissionDelete =:permissionDelete");
       Query query=s.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
        if (permissionId!=null&&!"".equals(permissionId)){
           query.setParameter("permissionId",permissionId);
        }
        if(permissionName!=null&&!"".equals(permissionName)){
          query.setParameter("permissionName",permissionName);
        }
        if(permissionLevel!=null&&!"".equals(permissionLevel)){
           query.setParameter("permissionLevel",permissionLevel);
        }
        query.setParameter("permissionDelete",1);
        return query.list();
    }

    @Override
    public Long findTotalPermission(Permission permission) {
        Session s=sessionFactory.getCurrentSession();
        Long permissionId=permission.getPermissionId();
        String permissionName=permission.getPermissionName();
        String permissionLevel=permission.getPermissionLevel();
        StringBuffer hql=new StringBuffer("from Permission where 1=1");
        if (permissionId!=null&&!"".equals(permissionId)){
            hql.append("and permissionId= :permissionId");
        }
        if(permissionName!=null&&!"".equals(permissionName)){
            hql.append("and permissionName= :permissionName");
        }
        if(permissionLevel!=null&&!"".equals(permissionLevel)){
            hql.append("and permissionLevel = :permissionLevel");
        }
        hql.append("and permissionDelete =:permissionDelete");
        Query query=s.createQuery(hql.toString());
        if (permissionId!=null&&!"".equals(permissionId)){
            query.setParameter("permissionId",permissionId);
        }
        if(permissionName!=null&&!"".equals(permissionName)){
            query.setParameter("permissionName",permissionName);
        }
        if(permissionLevel!=null&&!"".equals(permissionLevel)){
            query.setParameter("permissionLevel",permissionLevel);
        }
        query.setParameter("permissionDelete",1);
        return (Long)query.uniqueResult();
    }

    @Override
    public List<Permission> allListPermission(Permission permission) {
        Session s=sessionFactory.getCurrentSession();
        Long permissionId=permission.getPermissionId();
        String permissionName=permission.getPermissionName();
        String permissionLevel=permission.getPermissionLevel();
        StringBuffer hql=new StringBuffer("from Permission where 1=1");
        if (permissionId!=null&&!"".equals(permissionId)){
            hql.append(" and permissionId= :permissionId");
        }
        if(permissionName!=null&&!"".equals(permissionName)){
            hql.append(" and permissionName= :permissionName");
        }
        if(permissionLevel!=null&&!"".equals(permissionLevel)){
            hql.append(" and permissionLevel = :permissionLevel");
        }
        hql.append(" and permissionDelete =:permissionDelete");
        Query query=s.createQuery(hql.toString());
        if (permissionId!=null&&!"".equals(permissionId)){
            query.setParameter("permissionId",permissionId);
        }
        if(permissionName!=null&&!"".equals(permissionName)){
            query.setParameter("permissionName",permissionName);
        }
        if(permissionLevel!=null&&!"".equals(permissionLevel)){
            query.setParameter("permissionLevel",permissionLevel);
        }
        query.setParameter("permissionDelete",1);
        return query.list();
    }

    @Override
    public boolean isExisr(Permission permission) {
        Session s=sessionFactory.getCurrentSession();
        StringBuffer hql=new StringBuffer("select count(*) from Permission where permissionName=:permissionName and permissionDelete= :permissionDelete");
        Query q=s.createQuery(hql.toString());
        q.setParameter("permissionName",permission.getPermissionName());
        q.setParameter("permissionDelete",1);
        long count=(long)q.uniqueResult();
        if(count==0){
            return false;
        }
        return true;
    }
}
