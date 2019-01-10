package com.cwp.service.impl;

import com.cwp.dao.PictureDao;
import com.cwp.entity.Page;
import com.cwp.entity.Picture;
import com.cwp.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao pictureDao;

    @Override
    public boolean addPicture(Picture picture) {
        return pictureDao.addPicture(picture);
    }

    @Override
    public boolean deletePicture(Picture picture) {
        return pictureDao.deletePicture(picture);
    }

    @Override
    public boolean updatePicture(Picture picture) {
        return pictureDao.updatePicture(picture);
    }

    @Override
    public List<Picture> listPicture(Picture picture, Page page) {
        return pictureDao.listPicture(picture,page);
    }

    @Override
    public Picture findPicture(Picture picture) {
        return pictureDao.findPicture(picture);
    }

    @Override
    public List<Picture> allListPicture(Picture picture) {
        return pictureDao.allListPicture(picture);
    }
}
