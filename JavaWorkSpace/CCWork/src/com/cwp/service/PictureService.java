package com.cwp.service;

import com.cwp.entity.Page;
import com.cwp.entity.Picture;

import java.util.List;

public interface PictureService {
    //添加图片
    boolean addPicture(Picture picture);
    //删除图片
    boolean deletePicture(Picture picture);
    //修改图片
    boolean updatePicture(Picture picture);
    //返回图片队列
    List<Picture> listPicture(Picture picture, Page page);
    //返回图片单条信息
    Picture findPicture(Picture picture);
}
