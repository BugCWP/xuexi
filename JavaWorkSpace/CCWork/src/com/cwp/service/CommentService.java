package com.cwp.service;

import com.cwp.entity.Comment;
import com.cwp.entity.Page;

import java.util.List;

public interface CommentService {
    //添加评论
    boolean addComment(Comment comment);
    //删除评论
    boolean deleteComment(Comment comment);
    //修改评论
    boolean updateComment(Comment comment);
    //返回评论队列
    List<Comment> listComment(Comment comment, Page page);
    //返回评论单条信息
    Comment findComment(Comment comment);
//    返回评论数量
    Long findTotalComment(Comment comment);
}
