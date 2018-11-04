package com.cwp.action;

import com.cwp.entity.Resident;
import com.cwp.service.ResidentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@ParentPackage("struts-default")
@Namespace("/resident")
@Results({@Result(name ="error",type = "dispatcher",location = "/error.jsp")})
public class ResidentAction extends ActionSupport implements ModelDriven<Resident> {
    private Resident resident=new Resident();

    @Autowired
    private ResidentService residentService;

    //添加接口
    @Action(value = "addResident",results = {@Result(name = "success",type = "dispatcher",location = "/index.jsp")})
    public String addResident(){
        boolean flag=residentService.addResident(resident);
        if (flag){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    //注册接口
    @Action(value = "register",results = {@Result(name = "success",type = "dispatcher",location = "/index.jsp")})
    public String registerResident(){
        System.out.print(resident.toString());
        return SUCCESS;
    }
    //删除接口
    //修改接口
    //数组信息
    //单条信息
    @Override
    public Resident getModel() {
        return resident;
    }
}
