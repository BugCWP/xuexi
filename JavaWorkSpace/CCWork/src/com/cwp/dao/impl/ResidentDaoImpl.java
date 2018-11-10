package com.cwp.dao.impl;

import com.cwp.dao.ResidentDao;
import com.cwp.entity.Page;
import com.cwp.entity.Resident;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResidentDaoImpl implements ResidentDao {

    @Autowired
    private SessionFactory sessionFactory;

    //    添加居民
    @Override
    public boolean addResident(Resident resident) {
        resident.setResidentDelete(1);
        sessionFactory.getCurrentSession().save(resident);
        return true;
    }

    //     是否已存在
    @Override
    public boolean isExisr(String residentaccount) {
        Session s=sessionFactory.getCurrentSession();
        StringBuffer hql=new StringBuffer("select count(*) from Resident where residentAccount=:residentAccount and residentDelete= :residentDelete");
        Query q=s.createQuery(hql.toString());
        q.setParameter("residentAccount",residentaccount);
        q.setParameter("residentDelete",1);
        long count=(long)q.uniqueResult();
        if(count==0){
            return false;
        }
        return true;
    }

    //   删除居民
    @Override
    public boolean deleteResident(Resident resident) {
        Session s=sessionFactory.getCurrentSession();
        String residentAccount=resident.getResidentAccount();
        String residentName=resident.getResidentName();
        String residentCommunity=resident.getResidentCommunity();
        String residentPhone=resident.getResidentPhone();
        String residentAdress=resident.getResidentAdress();
        String residentAge=resident.getResidentAge();
        Long id=resident.getResidentId();
        Resident r=new Resident();
        if(residentAccount!=null &&!"".equals(residentAccount)){
            r=s.get(Resident.class,resident.getResidentAccount());
        }
        else if (residentName!=null&&!"".equals(residentName)){
            r=s.get(Resident.class,resident.getResidentName());
        }
        else if (residentCommunity!=null &&!"".equals(residentCommunity)){
            r=s.get(Resident.class,resident.getResidentCommunity());
        }
        else if (residentPhone!=null&&!"".equals(residentPhone)){
            r=s.get(Resident.class,resident.getResidentPhone());
        }
        else if (residentAdress!=null&&!"".equals(residentAdress)){
            r=s.get(Resident.class,resident.getResidentAdress());
        }
        else if (residentAge!=null &&!"".equals(residentAge)){
            r=s.get(Resident.class,resident.getResidentAge());
        }else if(id!=null){
            r=s.get(Resident.class,id);
        }
        r.setResidentDelete(0);
        s.update(r);
        return true;
    }

    //   修改居民
    @Override
    public boolean updateResident(Resident resident) {
        sessionFactory.getCurrentSession().update(resident);
        return true;
    }

    //   单个查询居民
    @Override
    public Resident findResident(Resident resident) {
        Session s=sessionFactory.getCurrentSession();
        String residentAccount=resident.getResidentAccount();
        Long id=resident.getResidentId();
        StringBuffer hql=new StringBuffer("from Resident where 1=1");
        if(residentAccount!=null &&!"".equals(residentAccount)){
            hql.append(" and residentAccount= :residentAccount");
        }
        if(id!=null){
            hql.append(" and residentId = :residentId");
        }
        Query query=s.createQuery(hql.toString());
        if(residentAccount!=null &&!"".equals(residentAccount)){
            query.setParameter("residentAccount",residentAccount);
        }
        if (id!=null){
            query.setParameter("residentId",id);
        }
        List<Resident> residentList= query.list();
        Resident r1=null;
        for (Resident r2:residentList){
            r1=r2;
        }
       return r1;
    }

    //   列表查询居民
    @Override
    public List<Resident> listResident(Resident resident, Page page) {
        Session s=sessionFactory.getCurrentSession();
        StringBuffer hql=new StringBuffer("from Resident where 1=1");
        String residentAccount=resident.getResidentAccount();
        String residentName=resident.getResidentName();
        String residentCommunity=resident.getResidentCommunity();
        String residentPhone=resident.getResidentPhone();
        String residentAdress=resident.getResidentAdress();
        String residentAge=resident.getResidentAge();
        int residentDelete=resident.getResidentDelete();
        if(residentAccount!=null &&!"".equals(residentAccount)){
            hql.append(" and residentAccount= :residentAccount");
        }
        if (residentName!=null&&!"".equals(residentName)){
            hql.append(" and residentName like :residentName");
        }
        if (residentCommunity!=null && !"".equals(residentCommunity)){
            hql.append(" and residentCommunity = :residentCommunity");
        }
        if (residentPhone!=null&&!"".equals(residentPhone)){
            hql.append(" and residentPhone like :residentPhone");
        }
        if (residentAdress!=null&&!"".equals(residentAdress)){
            hql.append(" and residentAdress like :residentAdress");
        }
        if (residentAge!=null &&!"".equals(residentAge)){
            hql.append(" and residentAge like :residentAge");
        }
        hql.append(" and residentDelete = :residentDelete");

        Query query=s.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
        if(residentAccount!=null &&!"".equals(residentAccount)){
            query.setParameter("residentAccount",residentAccount);
        }
        if (residentName!=null&&!"".equals(residentName)){
            query.setParameter("residentName","%"+residentName+"%");
        }
        if (residentCommunity!=null && !"".equals(residentCommunity)){
            query.setParameter("residentCommunity",residentCommunity);
        }
        if (residentPhone!=null&&!"".equals(residentPhone)){
            query.setParameter("residentPhone","%"+residentPhone+"%");
        }
        if (residentAdress!=null&&!"".equals(residentAdress)){
            query.setParameter("residentAdress","%"+residentAdress+"%");
        }
        if (residentAge!=null &&!"".equals(residentAge)){
            query.setParameter("residentAge","%"+residentAge+"%");
        }
        query.setParameter("residentDelete",residentDelete);
        return query.list();
    }

    //    查询居民数量
    @Override
    public Long findTotalCount(Resident resident) {
        Session s=sessionFactory.getCurrentSession();
        StringBuffer hql=new StringBuffer("select count(*) from Resident where 1=1");
        String residentAccount=resident.getResidentAccount();
        String residentName=resident.getResidentName();
        String residentCommunity=resident.getResidentCommunity();
        String residentPhone=resident.getResidentPhone();
        String residentAdress=resident.getResidentAdress();
        String residentAge=resident.getResidentAge();
        int residentDelete=resident.getResidentDelete();
        if(residentAccount!=null &&!"".equals(residentAccount)){
            hql.append(" and residentAccount= :residentAccount");
        }
        if (residentName!=null&&!"".equals(residentName)){
            hql.append(" and residentName like :residentName");
        }
        if (residentCommunity!=null && !"".equals(residentCommunity)){
            hql.append(" and residentCommunity = :residentCommunity");
        }
        if (residentPhone!=null&&!"".equals(residentPhone)){
            hql.append(" and residentPhone like :residentPhone");
        }
        if (residentAdress!=null&&!"".equals(residentAdress)){
            hql.append(" and residentAdress like :residentAdress");
        }
        if (residentAge!=null &&!"".equals(residentAge)){
            hql.append(" and residentAge like :residentAge");
        }
        hql.append(" and residentDelete = :residentDelete");
        Query query=s.createQuery(hql.toString());
        if(residentAccount!=null &&!"".equals(residentAccount)){
            query.setParameter("residentAccount",residentAccount);
        }
        if (residentName!=null&&!"".equals(residentName)){
            query.setParameter("residentName","%"+residentName+"%");
        }
        if (residentCommunity!=null&& !"".equals(residentCommunity)){
            query.setParameter("residentCommunity",residentCommunity);
        }
        if (residentPhone!=null&&!"".equals(residentPhone)){
            query.setParameter("residentPhone","%"+residentPhone+"%");
        }
        if (residentAdress!=null&&!"".equals(residentAdress)){
            query.setParameter("residentAdress","%"+residentAdress+"%");
        }
        if (residentAge!=null &&!"".equals(residentAge)){
            query.setParameter("residentAge","%"+residentAge+"%");
        }
        query.setParameter("residentDelete", residentDelete);
        return (Long) query.uniqueResult();
    }

    @Override
    public boolean loginResident(Resident resident) {
        Session session=sessionFactory.getCurrentSession();
        String hql="select count(*) from Resident where residentAccount= :residentAccount and residentPassword= :residentPassword";
        Query query=session.createQuery(hql);
        query.setParameter("residentAccount",resident.getResidentAccount());
        query.setParameter("residentPassword",resident.getResidentPassword());
        long count=(long)query.uniqueResult();
        System.out.println(count);
        if (count>0){
            return true;
        }
        return false;
    }
}
