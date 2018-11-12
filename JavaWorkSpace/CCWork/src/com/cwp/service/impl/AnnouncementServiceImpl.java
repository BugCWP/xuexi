package com.cwp.service.impl;

import com.cwp.dao.AnnouncementDao;
import com.cwp.entity.Announcement;
import com.cwp.entity.Page;
import com.cwp.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    private AnnouncementDao announcementDao;

    @Override
    public boolean addAnnouncement(Announcement announcement) {
        return false;
    }

    @Override
    public boolean deleteAnnouncement(Announcement announcement) {

        return announcementDao.deleteAnnouncement(announcement);
    }

    @Override
    public boolean updateAnnouncement(Announcement announcement) {

        return announcementDao.updateAnnouncement(announcement);
    }

    @Override
    public List<Announcement> listAnnouncement(Announcement announcement, Page page) {

        return announcementDao.listAnnouncement(announcement,page);
    }

    @Override
    public Announcement findAnnouncement(Announcement announcement) {

        return announcementDao.findAnnouncement(announcement);
    }

    @Override
    public Long findTotalCount(Announcement announcement) {
        return announcementDao.findTotalAnnouncement(announcement);
    }
}
