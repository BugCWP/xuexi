package com.cwp.dao;

import com.cwp.entity.Page;
import com.cwp.entity.Resident;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.util.List;

public interface ResidentDao {

    //    添加居民
     boolean addResident(Resident resident);

     //   删除居民
     boolean deleteResident(Resident resident);

    //   修改居民
    boolean updateResident(Resident resident);

    //   单个查询居民
    Resident findResident(Resident resident);

    //   列表查询居民
    List<Resident> listResident(Resident resident, Page page);

    //    查询居民数量
    Long findTotalCount(Resident resident);

    //     是否已存在
    boolean isExisr(String residentaccount);

    //登陆
    boolean loginResident(Resident resident);

    //查询所有居民
    List<Resident> allListResident(Resident resident);
}
