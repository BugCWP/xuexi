package com.cwp.service.impl;

import com.cwp.dao.CommunityDao;
import com.cwp.entity.Community;
import com.cwp.entity.Page;
import com.cwp.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    private CommunityDao communityDao;

    @Override
    public boolean addCommunity(Community community) {
        communityDao.addCommunity(community);
        return true;
    }

    @Override
    public boolean deleteCommunity(Community community) {
        communityDao.deleteCommunity(community);
        return true;
    }

    @Override
    public boolean updateCommunity(Community community) {
        communityDao.updateCommunity(community);
        return true;
    }

    @Override
    public List<Community> listCommunity(Community community, Page page) {
        return communityDao.listCommunity(community,page);
    }

    @Override
    public Community findCommunity(Community community) {

        return communityDao.findCommunity(community);
    }

    @Override
    public List<Community> listAllCommunity(Community community) {
        int count=(int)communityDao.findTotalCommunity(community);
        Page page=new Page();
        page.setPageSize(count);
        return communityDao.listCommunity(community,page);
//        return null;
    }

    @Override
    public Long findTotalCommunity(Community community) {
        return communityDao.findTotalCommunity(community);
    }
}
