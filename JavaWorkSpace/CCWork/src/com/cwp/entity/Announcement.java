package com.cwp.entity;

import javax.persistence.*;
import java.io.Serializable;

/*
*公告表
 */
@Entity
@Table(name = "announcement_table")
public class Announcement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "announcement_id",nullable = false)
    private Long announcementId;
    @Column(name = "announcement_title")
    private String announcementTitle;
    @Column(name = "announcement_table")
    private String announcementTable;
    @Column(name = "announcement_picture")
    private String announcementPicture;
    @Column(name = "announcement_time")
    private String  announcementTime;
    @Column(name = "announcement_persion")
    private Long announcementPersion;
    @Column(name = "announcement_comment")
    private String announcementComment;
    @Column(name = "announcement_delete")
    private int announcementDelete;

    public Long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public String getAnnouncementTable() {
        return announcementTable;
    }

    public void setAnnouncementTable(String announcementTable) {
        this.announcementTable = announcementTable;
    }

    public String getAnnouncementPicture() {
        return announcementPicture;
    }

    public void setAnnouncementPicture(String announcementPicture) {
        this.announcementPicture = announcementPicture;
    }

    public String getAnnouncementTime() {
        return announcementTime;
    }

    public void setAnnouncementTime(String announcementTime) {
        this.announcementTime = announcementTime;
    }

    public Long getAnnouncementPersion() {
        return announcementPersion;
    }

    public void setAnnouncementPersion(Long announcementPersion) {
        this.announcementPersion = announcementPersion;
    }

    public String getAnnouncementComment() {
        return announcementComment;
    }

    public void setAnnouncementComment(String announcementComment) {
        this.announcementComment = announcementComment;
    }

    public int getAnnouncementDelete() {
        return announcementDelete;
    }

    public void setAnnouncementDelete(int announcementDelete) {
        this.announcementDelete = announcementDelete;
    }
}
