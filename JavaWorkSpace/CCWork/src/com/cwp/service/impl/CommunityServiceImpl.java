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
        return false;
    }

    @Override
    public boolean deleteCommunity(Community community) {
        return false;
    }

    @Override
    public boolean updateCommunity(Community community) {
        return false;
    }

    @Override
    public List<Community> listCommunity(Community community, Page page) {
        return communityDao.listCommunity(community,page);
    }

    @Override
    public Community findCommunity(Community community) {
        return null;
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
