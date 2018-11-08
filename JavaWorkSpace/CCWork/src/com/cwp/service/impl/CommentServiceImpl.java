package com.cwp.service.impl;

import com.cwp.dao.CommentDao;
import com.cwp.entity.Comment;
import com.cwp.entity.Page;
import com.cwp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public boolean addComment(Comment comment) {
        return false;
    }

    @Override
    public boolean deleteComment(Comment comment) {
        return false;
    }

    @Override
    public boolean updateComment(Comment comment) {
        return false;
    }

    @Override
    public List<Comment> listComment(Comment comment, Page page) {
        return null;
    }

    @Override
    public Comment findComment(Comment comment) {
        return null;
    }

    @Override
    public Long findTotalComment(Comment comment) {
        return commentDao.findTotalComment(comment);
    }
}
