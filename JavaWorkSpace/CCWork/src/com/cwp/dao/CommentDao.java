package com.cwp.dao;

import com.cwp.entity.Comment;
import com.cwp.entity.Page;

import java.util.List;

public interface CommentDao {
    //添加社区
    boolean addComment(Comment comment);
    //修改社区
    boolean updateComment(Comment comment);
    //删除社区
    boolean deleteComment(Comment comment);
    //查询单个社区
    Comment findComment(Comment comment);
    //查询社区列表
    List<Comment> listComment(Comment comment, Page page);
    //查询所有评论
    List<Comment> allListComment(Comment comment);
    //查询社区数量
    Long findTotalComment(Comment comment);
}
