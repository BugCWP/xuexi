package com.cwp.dao;

import com.cwp.entity.Page;
import com.cwp.entity.Picture;

import java.util.List;

public interface PictureDao {
    //添加照片
    boolean addCommunity(Picture picture);
    //修改照片
    boolean updateCommunity(Picture picture);
    //删除照片
    boolean deleteCommunity(Picture picture);
    //查询单个照片
    Picture findCommunity(Picture picture);
    //查询照片列表
    List<Picture> listCommunity(Picture picture, Page page);
    //查询照片数量
    Long findTotalCommunity(Picture picture);
}
