package com.cwp.service;

import com.cwp.entity.Announcement;
import com.cwp.entity.Page;

import java.util.List;

public interface AnnouncementService {
    //添加公告
    boolean addAnnouncement(Announcement announcement);
    //删除公告
    boolean deleteAnnouncement(Announcement announcement);
    //修改公告
    boolean updateAnnouncement(Announcement announcement);
    //返回公告队列
    List<Announcement> listAnnouncement(Announcement announcement, Page page);
    //返回公告单条信息
    Announcement findAnnouncement(Announcement announcement);
    //返回公告数
    Long findTotalCount(Announcement announcement);
}
