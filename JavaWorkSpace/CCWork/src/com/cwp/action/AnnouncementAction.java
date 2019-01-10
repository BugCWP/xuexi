package com.cwp.action;

import com.cwp.entity.*;
import com.cwp.service.AnnouncementService;
import com.cwp.service.CommentService;
import com.cwp.service.PictureService;
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
import javax.servlet.http.HttpSession;
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
    @Autowired
    private PictureService pictureService;
    @Autowired
    private CommentService commentService;

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


    //给主页返回公告信息，只能看见自己社区的公告
    @Action(value = "getannouncementlist")
    public void getAnnouncementList() throws IOException{
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        Resident r=(Resident) session.getAttribute("user");
        Resident r1=new Resident();
        r1.setResidentId(r.getResidentId());
        Resident r2=residentService.findResident(r1);
        Resident r3=new Resident();
        r3.setResidentCommunity(r2.getResidentCommunity());
        List<Resident> residentList=residentService.allListResident(r3);
        List<Map> mapList=new ArrayList<>();
        for (Resident i:residentList){
            Announcement a=new Announcement();
            a.setAnnouncementPersion(i.getResidentId());
            List<Announcement> announcementList=announcementService.allListAnnouncement(a);
            Map map=new HashMap();
            List<Map> mapList1=new ArrayList<>();
            for (Announcement j:announcementList){
                Picture p=new Picture();
                p.setPictureNumber(j.getAnnouncementPicture());
                List<Picture> pictureList=pictureService.allListPicture(p);
                Picture p2=new Picture();
                p2.setPictureNumber(i.getResidentAvatar());
                Picture p1=pictureService.findPicture(p2);
                if (p1==null){
                    p1.setPictureUrl("/nothing.jsp");
                }
                Map map1=new HashMap();
                map1.put("announcement",j);
                map1.put("pictureList",pictureList);
                map1.put("picture",p1);
                map1.put("residnt",i);
                mapList1.add(map1);
            }
            map.put("announcementList",mapList1);
            mapList.add(map);
        }
        String jsonString=JSONArray.fromObject(mapList).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }

    //获取一个单独的公告以及其所有评论
    @Action(value = "announcementPage",results = {@Result(name = SUCCESS,type = "dispatcher",location = "/AnnouncementPage.jsp")})
    public String announcementPage(){
        HttpServletRequest request=ServletActionContext.getRequest();
        Long id=announcement.getAnnouncementId();
        Announcement a=new Announcement();
        a.setAnnouncementId(id);
        Announcement a1=announcementService.findAnnouncement(a);
        request.setAttribute("announcementtime",a1.getAnnouncementTime());
        request.setAttribute("announcementtitle",a1.getAnnouncementTitle());
        request.setAttribute("announcementtable",a1.getAnnouncementTable());
        request.setAttribute("announcementId",a1.getAnnouncementId());
        Picture p4=new Picture();
        p4.setPictureNumber(a1.getAnnouncementPicture());
        List<Picture> pictureList=pictureService.allListPicture(p4);
        request.setAttribute("announcementPicture",pictureList);
        Resident r=new Resident();
        r.setResidentId(a1.getAnnouncementPersion());
        Resident r1=residentService.findResident(r);
        request.setAttribute("announcementresidentname",r1.getResidentName());
        Picture p=new Picture();
        p.setPictureNumber(r1.getResidentAvatar());
        Picture p1=pictureService.findPicture(p);
        if (p1==null){
            p1.setPictureUrl("/nothing.jpg");
        }
        request.setAttribute("announcementresidentpicture",p1.getPictureUrl());
        Comment c=new Comment();
        c.setCommentNumber(a1.getAnnouncementId().toString());
        List<Comment> commentList=commentService.allListComment(c);
        List<Map> mapList=new ArrayList<>();
        for (Comment c1:commentList){
             Resident r2=new Resident();
             r2.setResidentId(c1.getCommentPersion());
             Resident r3=residentService.findResident(r2);
             Picture p2=new Picture();
             p2.setPictureNumber(r3.getResidentAvatar());
             Picture p3=pictureService.findPicture(p2);
             Map map=new HashMap();
             map.put("resident",r3);
             map.put("comment",c1);
             map.put("picture",p3);
             mapList.add(map);
        }
        request.setAttribute("maplist",mapList);
        return SUCCESS;
    }


    @Override
    public Announcement getModel() {
        return announcement;
    }
}
