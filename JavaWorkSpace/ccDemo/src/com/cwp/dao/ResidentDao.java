package com.cwp.dao;

import com.cwp.entity.Resident;

public interface ResidentDao {

    //    添加居民
     boolean addResident(Resident resident);

     //     是否已存在
    boolean isExisr(String residentaccount);
}
