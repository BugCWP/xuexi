package com.cwp.dao.impl;

import com.cwp.dao.CommentDao;
import com.cwp.entity.Comment;
import com.cwp.entity.Page;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addComment(Comment comment) {
        Session session=sessionFactory.getCurrentSession();
        comment.setCommentDelete(1);
        session.save(comment);
        return true;
    }

    @Override
    public boolean updateComment(Comment comment) {
        Session session=sessionFactory.getCurrentSession();
        session.update(comment);
        return true;
    }

    @Override
    public boolean deleteComment(Comment comment) {
        Session session=sessionFactory.getCurrentSession();
        Long commentId=comment.getCommentId();
        Comment c=new Comment();
        if(commentId!=null&&"".equals(commentId)){
            c=session.get(Comment.class,commentId);
        }
        c.setCommentDelete(0);
        session.update(c);
        return true;
    }

    @Override
    public Comment findComment(Comment comment) {
        Session session=sessionFactory.getCurrentSession();
        Long commentId=comment.getCommentId();
        Comment c=new Comment();
        if(commentId!=null&&"".equals(commentId)) {
            c = session.get(Comment.class, commentId);
        }
        return c;
    }

    @Override
    public List<Comment> listComment(Comment comment, Page page) {
        Session session=sessionFactory.getCurrentSession();
        String  commentNumber=comment.getCommentNumber();
        Long commentPersion=comment.getCommentPersion();
        StringBuffer hql=new StringBuffer("from Comment where 1=1");
        if (commentNumber!=null&&"".equals(commentNumber)){
            hql.append("and commentNumber = :commentNumber");
        }
        if (commentPersion!=null&&"".equals(commentPersion)){
            hql.append("and commentPersion = :commentPersion");
        }
        hql.append("and commentDelete = :commentDelete");
        Query query=session.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
        if (commentNumber!=null&&"".equals(commentNumber)){
           query.setParameter("commentNumber",commentNumber);
        }
        if (commentPersion!=null&&"".equals(commentPersion)){
            query.setParameter("commentPersion",commentPersion);
        }
        query.setParameter("commentDelete",1);
        return query.list();
    }

    @Override
    public Long findTotalComment(Comment comment) {
        Session session=sessionFactory.getCurrentSession();
        String  commentNumber=comment.getCommentNumber();
        Long commentPersion=comment.getCommentPersion();
        StringBuffer hql=new StringBuffer("from Comment where 1=1");
        if (commentNumber!=null&&"".equals(commentNumber)){
            hql.append("and commentNumber = :commentNumber");
        }
        if (commentPersion!=null&&"".equals(commentPersion)){
            hql.append("and commentPersion = :commentPersion");
        }
        hql.append("and commentDelete = :commentDelete");
        Query query=session.createQuery(hql.toString());
        if (commentNumber!=null&&"".equals(commentNumber)){
            query.setParameter("commentNumber",commentNumber);
        }
        if (commentPersion!=null&&"".equals(commentPersion)){
            query.setParameter("commentPersion",commentPersion);
        }
        query.setParameter("commentDelete",1);
        return (Long) query.uniqueResult();
    }

}
