package com.cwp.action;

import com.cwp.entity.Page;
import com.cwp.entity.Permission;
import com.cwp.entity.Resident;
import com.cwp.service.PermissionService;
import com.cwp.service.ResidentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.hibernate.Session;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ParentPackage("struts-default")
@Namespace("/permission")
public class PermissionAction extends ActionSupport implements ModelDriven<Permission> {

    private Permission permission=new Permission();
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ResidentService residentService;

    @Action(value = "listPermissionbypage")
    public void getListPermissionByPage() throws IOException {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String permissionPageIndex=request.getParameter("permissionPageIndex");
        String permissionPageSize=request.getParameter("permissionPageSize");
        String permissionFindType=request.getParameter("permissionFindType");
        String permissionText=request.getParameter("permissionText");
        Page page=new Page();
        page.setPageIndex(Integer.parseInt(permissionPageIndex));
        page.setPageSize(Integer.parseInt(permissionPageSize));
        List<Resident> residentList=new ArrayList<>();
        if (!"".equals(permissionFindType)){
            Resident r=new Resident();
            if (!"".equals(permissionText)){
                r.setResidentName(permissionText);
            }
            r.setResidentDelete(1);
            r.setResidentPermission(Long.parseLong(permissionFindType));
            residentList=residentService.listResident(r,page);
        }else {
            Resident r=new Resident();
            if (!"".equals(permissionText)){
                r.setResidentName(permissionText);
            }
            r.setResidentDelete(1);
            residentList=residentService.listResident(r,page);
        }
        List<Map> mapList=new ArrayList<>();
        HttpSession session=request.getSession();
        Resident user=(Resident) session.getAttribute("user");
        for (Resident i:residentList){
            Permission p=new Permission();
            p.setPermissionId(i.getResidentPermission());
            String permissionName=permissionService.findPermission(p).getPermissionName();
            Map map=new HashMap();
            map.put("permissionresident",i);
            map.put("permissionname",permissionName);
            map.put("permissionlevel",user.getResidentPermission());
            mapList.add(map);
        }
        String jsonString= JSONArray.fromObject(mapList).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }


    @Action(value = "getpermissiontotalcount")
    public void getPermissionTotalCount() throws IOException{
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String permissionFindType=request.getParameter("permissionFindType");
        String permissionText=request.getParameter("permissionText");
        long count=0;
        if (!"".equals(permissionFindType)){
            Resident r=new Resident();
            if (!"".equals(permissionText)){
                r.setResidentName(permissionText);
            }
            r.setResidentDelete(1);
            r.setResidentPermission(Long.parseLong(permissionFindType));
            count=residentService.findTotalCount(r);
        }else {
            Resident r=new Resident();
            if (!"".equals(permissionText)){
                r.setResidentName(permissionText);
            }
            r.setResidentDelete(1);
            count=residentService.findTotalCount(r);
        }
        Map jsonMap=new HashMap();
        jsonMap.put("permissionTotalCount",count);
        String jsonString= JSONObject.fromObject(jsonMap).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }

    //获取权限表
    @Action(value = "permissionlist")
    public void getPermissionList() throws IOException{
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        List<Permission> permissionList=permissionService.allListPermission(new Permission());
        String jsonString=JSONArray.fromObject(permissionList).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }

    //获取单一权限
    @Action(value = "findpermission")
    public void FindPermission() throws IOException{
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String id=request.getParameter("id");
        Permission p=new Permission();
        p.setPermissionId(Long.parseLong(id));
        Permission p2=permissionService.findPermission(p);
        Map jsonMap=new HashMap();
        jsonMap.put("name",p2.getPermissionName());
        String jsonString=JSONObject.fromObject(jsonMap).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }

    //修改用户权限
    @Action(value = "updateresidentpermission")
    public void UpdateResidentPermission() throws IOException{
        HttpServletRequest request= ServletActionContext.getRequest();
        String residentId=request.getParameter("residentId");
        String permissionId=request.getParameter("permissionId");
        Resident r=new Resident();
        r.setResidentId(Long.parseLong(residentId));
        Resident r1=residentService.findResident(r);
        r1.setResidentPermission(Long.parseLong(permissionId));
        residentService.updateResident(r1);
    }

    @Override
    public Permission getModel() {
        return permission;
    }
}
