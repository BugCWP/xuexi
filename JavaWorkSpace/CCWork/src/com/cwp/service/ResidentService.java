package com.cwp.service;

import com.cwp.entity.Page;
import com.cwp.entity.Resident;

import java.util.List;

public interface ResidentService {
    //添加居民
    boolean addResident(Resident resident);
    //删除居民
    boolean deleteResident(Resident resident);
    //修改居民
    boolean updateResident(Resident resident);
    //返回居民队列
    List<Resident> listResident(Resident resident, Page page);
    //返回居民单条信息
    Resident findResident(Resident resident);
}
