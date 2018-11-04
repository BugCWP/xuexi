package com.cwp.entity;

import javax.persistence.*;
import java.io.Serializable;

/*
*评论表
 */
@Entity
@Table(name = "comment_table")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id",nullable = false)
    private Long commentId;
    @Column(name = "comment_number")
    private String commentNumber;
    @Column(name = "comment_table")
    private String commentTable;
    @Column(name = "comment_time")
    private String commentTime;
    @Column(name = "comment_persion")
    private Long commentPersion;
    @Column(name = "comment_picture")
    private String commentPicture;
    @Column(name = "comment_delete")
    private int commentDelete;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentPicture() {
        return commentPicture;
    }

    public void setCommentPicture(String commentPicture) {
        this.commentPicture = commentPicture;
    }

    public String getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(String commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getCommentTable() {
        return commentTable;
    }

    public void setCommentTable(String commentTable) {
        this.commentTable = commentTable;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public Long getCommentPersion() {
        return commentPersion;
    }

    public void setCommentPersion(Long commentPersion) {
        this.commentPersion = commentPersion;
    }

    public int getCommentDelete() {
        return commentDelete;
    }

    public void setCommentDelete(int commentDelete) {
        this.commentDelete = commentDelete;
    }
}
