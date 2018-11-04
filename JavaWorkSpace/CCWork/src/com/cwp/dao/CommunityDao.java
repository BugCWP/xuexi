package com.cwp.dao;

import com.cwp.entity.Community;
import com.cwp.entity.Page;

import java.util.List;

public interface CommunityDao {
    //添加社区
    boolean addCommunity(Community community);
    //修改社区
    boolean updateCommunity(Community community);
    //删除社区
    boolean deleteCommunity(Community community);
    //查询单个社区
    Community findCommunity(Community community);
    //查询社区列表
    List<Community> listCommunity(Community community, Page page);
    //查询社区数量
    Long findTotalCommunity(Community community);
    //查询社区是否存在
    boolean isExisr(Community community);
}
