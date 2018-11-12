package com.cwp.action;

import com.cwp.entity.Announcement;
import com.cwp.entity.Page;
import com.cwp.entity.Resident;
import com.cwp.service.AnnouncementService;
import com.cwp.service.ResidentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ParentPackage("struts-default")
@Namespace("/announcement")
@Results(@Result(name = "500",type = "dispatcher",location = "/500.jsp"))
public class AnnouncementAction extends ActionSupport implements ModelDriven<Announcement> {
    private Announcement announcement=new Announcement();

    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private ResidentService residentService;

    //分页获取公告队列
    @Action(value = "listannouncementbypage")
    public void getListAnnouncementByPage() throws IOException{
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String announcementFindType=request.getParameter("announcementFindType");
        String announcementText=request.getParameter("announcementText");
        String announcementDeleteOrStay=request.getParameter("announcementDeleteOrStay");
        String announcementPageIndex=request.getParameter("announcementPageIndex");
        String announcementPageSize=request.getParameter("announcementPageSize");
        Announcement a=new Announcement();
        Page page=new Page();
        if (!"".equals(announcementFindType)){
            if ("announcementTitle".equals(announcementFindType)){
                a.setAnnouncementTitle(announcementText);
            }
            if ("announcementTime".equals(announcementFindType)){
                a.setAnnouncementTime(announcementText);
            }
            if ("announcementResident".equals(announcementFindType)){
                Resident r=new Resident();
                r.setResidentName(announcementText);
                r.setResidentDelete(1);
                Resident resident=residentService.findResident(r);
                a.setAnnouncementPersion(resident.getResidentId());
            }
        }
        a.setAnnouncementDelete(Integer.parseInt(announcementDeleteOrStay));
        page.setPageIndex(Integer.parseInt(announcementPageIndex));
        page.setPageSize(Integer.parseInt(announcementPageSize));
        List<Announcement> announcementList=announcementService.listAnnouncement(a,page);
        List<Map> mapList=new ArrayList<>();
        for (Announcement i:announcementList){
            Map map=new HashMap();
            Resident r2=new Resident();
            r2.setResidentId(i.getAnnouncementPersion());
            Resident r3=residentService.findResident(r2);
            String residentName=r3.getResidentName();
            map.put("announcement",i);
            map.put("residentName",residentName);
            mapList.add(map);
        }
        String jsonString= JSONArray.fromObject(mapList).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }

    //获取公告数量
    @Action(value = "announcementTotalCount")
    public void getAnnouncementTotalCount() throws IOException {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String announcementFindType=request.getParameter("announcementFindType");
        String announcementText=request.getParameter("announcementText");
        String announcementDeleteOrStay=request.getParameter("announcementDeleteOrStay");
        Announcement a=new Announcement();
        if (!"".equals(announcementFindType)){
            if ("announcementTitle".equals(announcementFindType)){
                 a.setAnnouncementTitle(announcementText);
            }
            if ("announcementTime".equals(announcementFindType)){
                 a.setAnnouncementTime(announcementText);
            }
            if ("announcementResident".equals(announcementFindType)){
                Resident r=new Resident();
                 r.setResidentName(announcementText);
                 r.setResidentDelete(1);
                 Resident resident=residentService.findResident(r);
                 a.setAnnouncementPersion(resident.getResidentId());
            }
        }
        a.setAnnouncementDelete(Integer.parseInt(announcementDeleteOrStay));
        Long count=announcementService.findTotalCount(a);
        Map jsonmap=new HashMap();
        jsonmap.put("announcementTotalCount",count);
        String jsonString= JSONObject.fromObject(jsonmap).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }

    //删除接口
    @Action(value = "deleteannouncement")
    public void DeleteAnnouncement(){
        HttpServletRequest request=ServletActionContext.getRequest();
        String id=request.getParameter("id");
        Announcement a=new Announcement();
        a.setAnnouncementId(Long.parseLong(id));
        announcementService.deleteAnnouncement(a);
    }

    //添加回去接口
    @Action(value = "announcementjie")
    public void AnnouncementJie(){
        HttpServletRequest request=ServletActionContext.getRequest();
        String id=request.getParameter("id");
        Announcement a=new Announcement();
        a.setAnnouncementId(Long.parseLong(id));
        Announcement a1=announcementService.findAnnouncement(a);
        a1.setAnnouncementDelete(1);
        announcementService.updateAnnouncement(a1);
    }

    //查询单个接口
    @Action(value = "findannouncement")
    public void FindAnnouncement()throws IOException{
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String id=request.getParameter("id");
        Announcement a=new Announcement();
        Resident r=new Resident();
        a.setAnnouncementId(Long.parseLong(id));
        Announcement a1=announcementService.findAnnouncement(a);
        r.setResidentId(a1.getAnnouncementPersion());
        Resident r2=residentService.findResident(r);
        Map jsonMap=new HashMap();
        jsonMap.put("announcement",a1);
        jsonMap.put("resident",r2.getResidentName());
        String jsonString=JSONObject.fromObject(jsonMap).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }

    @Override
    public Announcement getModel() {
        return announcement;
    }
}
