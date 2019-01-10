package com.cwp.dao.impl;

import com.cwp.dao.AnnouncementDao;
import com.cwp.entity.Announcement;
import com.cwp.entity.Page;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnnouncementDaoImpl implements AnnouncementDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addAnnouncement(Announcement announcement) {
        Session session=sessionFactory.getCurrentSession();
        announcement.setAnnouncementDelete(1);
        session.save(announcement);
        return false;
    }

    @Override
    public boolean updateAnnouncement(Announcement announcement) {
        Session session=sessionFactory.getCurrentSession();
        session.update(announcement);
        return true;
    }

    @Override
    public boolean deleteAnnouncement(Announcement announcement) {
        Session session=sessionFactory.getCurrentSession();
        Long announcementId=announcement.getAnnouncementId();
        String announcementTitle=announcement.getAnnouncementTitle();
        Announcement a=new Announcement();
        if (announcementId!=null&&!"".equals(announcementId)){
            a=session.get(Announcement.class,announcementId);
        }else if(announcementTitle!=null &&!"".equals(announcementTitle)){
            a=session.get(Announcement.class,announcementTitle);
        }
        a.setAnnouncementDelete(0);
        session.update(a);
        return true;
    }

    @Override
    public Announcement findAnnouncement(Announcement announcement) {
        Session session=sessionFactory.getCurrentSession();
        Long announcementId=announcement.getAnnouncementId();
        String announcementTitle=announcement.getAnnouncementTitle();
        Announcement a=new Announcement();
        if (announcementId!=null&&!"".equals(announcementId)){
            a=session.get(Announcement.class,announcementId);
        }else if(announcementTitle!=null &&!"".equals(announcementTitle)){
            a=session.get(Announcement.class,announcementTitle);
        }
        return a;
    }

    @Override
    public List<Announcement> listAnnouncement(Announcement announcement, Page page) {
        Session session=sessionFactory.getCurrentSession();
        Long announcementId=announcement.getAnnouncementId();
        String announcementTitle=announcement.getAnnouncementTitle();
        String announcementTime=announcement.getAnnouncementTime();
        Long announcementPersion=announcement.getAnnouncementPersion();
        StringBuffer hql=new StringBuffer("from Announcement where 1=1");
        if (announcementId!=null&&!"".equals(announcementId)){
            hql.append(" and announcementId= :announcementId");
        }
        if (announcementTitle!=null&&!"".equals(announcementTitle)){
            hql.append(" and announcementTitle like :announcementTitle");
        }
        if (announcementTime!=null &&!"".equals(announcementTime)){
            hql.append(" and announcementTime = :announcementTime");
        }
        if (announcementPersion!=null&&!"".equals(announcementPersion)){
            hql.append(" and announcementPersion = :announcementPersion");
        }
        hql.append(" and announcementDelete = :announcementDelete");
        Query query=session.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
        if (announcementId!=null&&!"".equals(announcementId)){
           query.setParameter("announcementId",announcementId);
        }
        if (announcementTitle!=null&&!"".equals(announcementTitle)){
            query.setParameter("announcementTitle",announcementTitle);
        }
        if (announcementTime!=null &&!"".equals(announcementTime)){
            query.setParameter("announcementTime",announcementTime);
        }
        if (announcementPersion!=null&&!"".equals(announcementPersion)){
            query.setParameter("announcementPersion",announcementPersion);
        }
        query.setParameter("announcementDelete",announcement.getAnnouncementDelete());
        return query.list();
    }

    @Override
    public Long findTotalAnnouncement(Announcement announcement) {
        Session session=sessionFactory.getCurrentSession();
        Long announcementId=announcement.getAnnouncementId();
        String announcementTitle=announcement.getAnnouncementTitle();
        String announcementTime=announcement.getAnnouncementTime();
        Long announcementPersion=announcement.getAnnouncementPersion();
        StringBuffer hql=new StringBuffer("select count(*) from Announcement where 1=1");
        if (announcementId!=null&&!"".equals(announcementId)){
            hql.append(" and announcementId= :announcementId");
        }
        if (announcementTitle!=null&&!"".equals(announcementTitle)){
            hql.append(" and announcementTitle like :announcementTitle");
        }
        if (announcementTime!=null &&!"".equals(announcementTime)){
            hql.append(" and announcementTime = :announcementTime");
        }
        if (announcementPersion!=null&&!"".equals(announcementPersion)){
            hql.append(" and announcementPersion = :announcementPersion");
        }
        hql.append(" and announcementDelete = :announcementDelete");
        Query query=session.createQuery(hql.toString());
        if (announcementId!=null&&!"".equals(announcementId)){
            query.setParameter("announcementId",announcementId);
        }
        if (announcementTitle!=null&&!"".equals(announcementTitle)){
            query.setParameter("announcementTitle","%"+announcementTitle+"%");
        }
        if (announcementTime!=null &&!"".equals(announcementTime)){
            query.setParameter("announcementTime",announcementTime);
        }
        if (announcementPersion!=null&&!"".equals(announcementPersion)){
            query.setParameter("announcementPersion",announcementPersion);
        }
        query.setParameter("announcementDelete",announcement.getAnnouncementDelete());
        return (Long) query.uniqueResult();
    }

    @Override
    public List<Announcement> allListAnnouncement(Announcement announcement) {
        Session session=sessionFactory.getCurrentSession();
        Long announcementId=announcement.getAnnouncementId();
        String announcementTitle=announcement.getAnnouncementTitle();
        String announcementTime=announcement.getAnnouncementTime();
        Long announcementPersion=announcement.getAnnouncementPersion();
        StringBuffer hql=new StringBuffer("from Announcement where 1=1");
        if (announcementPersion!=null&&!"".equals(announcementPersion)){
            hql.append(" and announcementPersion = :announcementPersion");
        }
        hql.append(" and announcementDelete = :announcementDelete");
        Query query=session.createQuery(hql.toString());
        if (announcementPersion!=null&&!"".equals(announcementPersion)){
            query.setParameter("announcementPersion",announcementPersion);
        }
        query.setParameter("announcementDelete",1);
        return query.list();
    }

    @Override
    public boolean isExisr(Announcement announcement) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer hql=new StringBuffer("select count(*) from Announcement where announcementTitle=:announcementTitle and announcementDelete= :announcementDelete");
        Query query=session.createQuery(hql.toString());
        query.setParameter("announcementTitle",announcement.getAnnouncementTitle());
        query.setParameter("announcementDelete",1);
        Long count=(Long)query.uniqueResult();
        if (count==0){
            return false;
        }
        return true;
    }
}
