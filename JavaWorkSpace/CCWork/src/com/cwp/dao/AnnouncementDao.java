package com.cwp.dao;

import com.cwp.entity.Announcement;
import com.cwp.entity.Page;

import java.util.List;

public interface AnnouncementDao {
    //添加社区
    boolean addAnnouncement(Announcement announcement);
    //修改社区
    boolean updateAnnouncement(Announcement announcement);
    //删除社区
    boolean deleteAnnouncement(Announcement announcement);
    //查询单个社区
    Announcement findAnnouncement(Announcement announcement);
    //查询社区列表
    List<Announcement> listAnnouncement(Announcement announcement, Page page);
    //查询社区数量
    Long findTotalAnnouncement(Announcement announcement);
    //查询社区是否存在
    boolean isExisr(Announcement announcement);
    //查询所有公告
    List<Announcement> allListAnnouncement(Announcement announcement);
}
