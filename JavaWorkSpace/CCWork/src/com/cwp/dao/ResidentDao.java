package com.cwp.dao;

import com.cwp.entity.Resident;

import java.util.List;

public interface ResidentDao {

    //    添加居民
     boolean addResident(Resident resident);

     //   删除居民
     boolean deleteResident(Resident resident);

    //   修改居民
    boolean updateResident(Resident resident);

    //   单个查询居民
    boolean findResident(String residentAccount);

    //   列表查询居民
    List<Resident> listResident();

    //    查询居民数量
    Long findTotalCount(Resident resident);

    //     是否已存在
    boolean isExisr(String residentaccount);
}
