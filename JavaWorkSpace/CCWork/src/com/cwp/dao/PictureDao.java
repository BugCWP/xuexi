package com.cwp.dao;

import com.cwp.entity.Page;
import com.cwp.entity.Picture;

import java.util.List;

public interface PictureDao {
    //添加照片
    boolean addPicture(Picture picture);
    //修改照片
    boolean updatePicture(Picture picture);
    //删除照片
    boolean deletePicture(Picture picture);
    //查询单个照片
    Picture findPicture(Picture picture);
    //查询照片列表
    List<Picture> listPicture(Picture picture, Page page);
    //查询照片数量
    Long findTotalPicture(Picture picture);
    //查询所有照片列表
    List<Picture> allListPicture(Picture picture);
}
