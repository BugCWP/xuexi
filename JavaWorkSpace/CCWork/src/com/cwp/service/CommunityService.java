package com.cwp.service;

import com.cwp.entity.Comment;
import com.cwp.entity.Community;
import com.cwp.entity.Page;

import java.util.List;

public interface CommunityService {
    //添加社区
    boolean addCommunity(Community community);
    //删除社区
    boolean deleteCommunity(Community community);
    //修改社区
    boolean updateCommunity(Community community);
    //返回社区队列
    List<Community> listCommunity(Community community, Page page);
    //查询所有社区列表
    List<Community> listAllCommunity(Community community);
    //返回社区单条信息
    Community findCommunity(Community community);
    //返回社区数
    Long findTotalCommunity(Community community);
}
