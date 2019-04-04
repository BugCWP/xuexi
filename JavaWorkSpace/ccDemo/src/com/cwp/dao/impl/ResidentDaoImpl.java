package com.cwp.dao.impl;

import com.cwp.dao.ResidentDao;
import com.cwp.entity.Resident;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ResidentDaoImpl implements ResidentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addResident(Resident resident) {
        sessionFactory.getCurrentSession().save(resident);
        return true;
    }

    @Override
    public boolean isExisr(String residentaccount) {
        Session s=sessionFactory.getCurrentSession();
        StringBuffer hql=new StringBuffer("select count(*) from Resident where residentAccount=:residentAccount");
        Query q=s.createQuery(hql.toString());
        q.setParameter("residentAccount",residentaccount);
        long count=(long)q.uniqueResult();
        if(count==0){
            return false;
        }
        return true;
    }
}
