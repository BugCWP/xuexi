package com.cwp.service.impl;

import com.cwp.dao.ResidentDao;
import com.cwp.entity.Page;
import com.cwp.entity.Resident;
import com.cwp.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class ResidentServiceImpl implements ResidentService {
    @Autowired
    private ResidentDao residentDao;

    @Override
    public boolean addResident(Resident resident) {
        boolean flag=residentDao.isExisr(resident.getResidentAccount());
        if(flag){
            return false;
        }else {
            residentDao.addResident(resident);
        }
        return true;
    }

    @Override
    public boolean deleteResident(Resident resident) {
        return false;
    }

    @Override
    public boolean updateResident(Resident resident) {
        return false;
    }

    @Override
    public List<Resident> listResident(Resident resident, Page page) {
        return null;
    }

    @Override
    public Resident findResident(Resident resident) {
        return null;
    }
}
