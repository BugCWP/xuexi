package com.cwp.dao.impl;

import com.cwp.dao.PictureDao;
import com.cwp.entity.Page;
import com.cwp.entity.Picture;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PictureDaoImpl implements PictureDao {
       @Autowired
       private SessionFactory sessionFactory;

    @Override
    public boolean addCommunity(Picture picture) {
        Session session=sessionFactory.getCurrentSession();
        picture.setPictureDelete(1);
        session.save(picture);
        return true;
    }

    @Override
    public boolean updateCommunity(Picture picture) {
        Session session=sessionFactory.getCurrentSession();
        session.update(picture);
        return true;
    }

    @Override
    public boolean deleteCommunity(Picture picture) {
        Session session=sessionFactory.getCurrentSession();
        Picture p=session.get(Picture.class,picture.getPictureId());
        p.setPictureDelete(0);
        session.update(p);
        return true;
    }

    @Override
    public Picture findCommunity(Picture picture) {
        Session session=sessionFactory.getCurrentSession();
        Picture p=session.get(Picture.class,picture.getPictureId());
        return p;
    }

    @Override
    public List<Picture> listCommunity(Picture picture, Page page) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer hql=new StringBuffer("from Picture where 1=1");
        String pictureNumber=picture.getPictureNumber();
        if (pictureNumber!=null&&"".equals(pictureNumber)){
            hql.append("and pictureNumber = :pictureNumber");
        }
        hql.append("and pictureDelete = :pictureDelete");
        Query query=session.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
        if (pictureNumber!=null && "".equals(pictureNumber)){
            query.setParameter("pictureNumber",pictureNumber);
        }
        query.setParameter("pictureDelete",1);
        return query.list();
    }

    @Override
    public Long findTotalCommunity(Picture picture) {
        Session session=sessionFactory.getCurrentSession();
        StringBuffer hql=new StringBuffer("from Picture where 1=1");
        String pictureNumber=picture.getPictureNumber();
        if (pictureNumber!=null&&"".equals(pictureNumber)){
            hql.append("and pictureNumber = :pictureNumber");
        }
        hql.append("and pictureDelete = :pictureDelete");
        Query query=session.createQuery(hql.toString());
        if (pictureNumber!=null && "".equals(pictureNumber)){
            query.setParameter("pictureNumber",pictureNumber);
        }
        query.setParameter("pictureDelete",1);
        return (Long) query.uniqueResult();
    }
}
