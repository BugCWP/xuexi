package com.cwp.dao.impl;

import com.cwp.dao.CommunityDao;
import com.cwp.entity.Community;
import com.cwp.entity.Page;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommunityDaoImpl implements CommunityDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addCommunity(Community community) {
        Session s=sessionFactory.getCurrentSession();
        community.setCommnityDelete(1);
        s.save(community);
        return true;
    }

    @Override
    public boolean updateCommunity(Community community) {
        Session s=sessionFactory.getCurrentSession();
        s.update(community);
        return true;
    }

    @Override
    public boolean deleteCommunity(Community community) {
        Session s=sessionFactory.getCurrentSession();
        String communityName=community.getCommunityName();
        String communityAdress=community.getCommnityAdress();
        Long communityId=community.getCommunityId();
        Community c=new Community();
        if (communityName!=null &&"".equals(communityName)){
             c =s.get(Community.class,community.getCommunityName());
        }
        else if (communityAdress!=null &&"".equals(communityAdress)){
            c =s.get(Community.class,community.getCommnityAdress());
        }
        else if (communityId!=null &&"".equals(communityId)){
            c =s.get(Community.class,community.getCommunityId());
        }
        c.setCommnityDelete(0);
        s.update(c);
        return true;
    }

    @Override
    public Community findCommunity(Community community) {
        Session s=sessionFactory.getCurrentSession();
        String communityName=community.getCommunityName();
        String communityAdress=community.getCommnityAdress();
        Long communityId=community.getCommunityId();
        Community c=new Community();
        if (communityName!=null &&"".equals(communityName)){
            c =s.get(Community.class,community.getCommunityName());
        }
        else if (communityAdress!=null &&"".equals(communityAdress)){
            c =s.get(Community.class,community.getCommnityAdress());
        }
        else if (communityId!=null &&"".equals(communityId)){
            c =s.get(Community.class,community.getCommunityId());
        }
        return c;
    }

    @Override
    public List<Community> listCommunity(Community community, Page page) {
        Session s=sessionFactory.getCurrentSession();
        String communityName=community.getCommunityName();
        String communityAdress=community.getCommnityAdress();
        Long communityId=community.getCommunityId();
        StringBuffer hql=new StringBuffer("from Community where 1=1");
        if (communityName!=null &&"".equals(communityName)){
            hql.append("and communityName like :communityName");
        }
        if (communityAdress!=null &&"".equals(communityAdress)){
            hql.append("and communityAdress like :communityName");
        }
        if (communityId!=null &&"".equals(communityId)){
            hql.append("and communityId like :communityId");
        }
        hql.append("and communityDelete = :communityDelete");
        Query query=s.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
        if (communityName!=null &&"".equals(communityName)){
           query.setParameter("communityName",communityName);
        }
        if (communityAdress!=null &&"".equals(communityAdress)){
           query.setParameter("communityAdress",communityAdress);
        }
        if (communityId!=null &&"".equals(communityId)){
            query.setParameter("communityId",communityId);
        }
        query.setParameter("communityId",1);
        return query.list();
    }

    @Override
    public Long findTotalCommunity(Community community) {
        Session s=sessionFactory.getCurrentSession();
        String communityName=community.getCommunityName();
        String communityAdress=community.getCommnityAdress();
        Long communityId=community.getCommunityId();
        StringBuffer hql=new StringBuffer("from Community where 1=1");
        if (communityName!=null &&"".equals(communityName)){
            hql.append("and communityName like :communityName");
        }
        if (communityAdress!=null &&"".equals(communityAdress)){
            hql.append("and communityAdress like :communityName");
        }
        if (communityId!=null &&"".equals(communityId)){
            hql.append("and communityId like :communityId");
        }
        hql.append("and communityDelete = :communityDelete");
        Query query=s.createQuery(hql.toString());
        if (communityName!=null &&"".equals(communityName)){
            query.setParameter("communityName",communityName);
        }
        if (communityAdress!=null &&"".equals(communityAdress)){
            query.setParameter("communityAdress",communityAdress);
        }
        if (communityId!=null &&"".equals(communityId)){
            query.setParameter("communityId",communityId);
        }
        query.setParameter("communityId",1);
        return (long)query.uniqueResult();
    }

    @Override
    public boolean isExisr(Community community) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer hql=new StringBuffer("select count(*) from Community where communityName=:communityName and communityDelete= :communityDelete");
        Query q=session.createQuery(hql.toString());
        q.setParameter("communityName",community.getCommunityName());
        q.setParameter("communityDelete",1);
        long count=(long)q.uniqueResult();
        if(count==0){
            return false;
        }
        return true;
    }
}
