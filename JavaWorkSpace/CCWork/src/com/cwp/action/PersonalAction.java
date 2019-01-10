package com.cwp.action;


import com.cwp.entity.*;
import com.cwp.service.*;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspApplicationContext;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ParentPackage("struts-default")
@Namespace("/personal")
public class PersonalAction extends ActionSupport {
    @Autowired
    private ResidentService residentService;

    @Autowired
    private CommunityService communityService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private PictureService pictureService;

    @Action(value = "getpersonalinformation")
    public void getPersonalInformation() throws IOException {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        Resident r=(Resident) session.getAttribute("user");
        Resident r1=new Resident();
        r1.setResidentId(r.getResidentId());
        Resident r2=residentService.findResident(r1);
        Community community=new Community();
        community.setCommunityId(Long.parseLong(r2.getResidentCommunity()));
        String communityName=communityService.findCommunity(community).getCommunityName();
        Permission permission=new Permission();
        permission.setPermissionId(r2.getResidentPermission());
        String permissionName=permissionService.findPermission(permission).getPermissionName();
        Picture picture=new Picture();
        picture.setPictureNumber(r2.getResidentAvatar());
        List<Picture> pictureList=pictureService.allListPicture(picture);
        Picture p2=new Picture();
        for (Picture i:pictureList){
           p2=i;
        }
        String pictureurl;
        if (p2==null){
            pictureurl="/noting.jpg";
        }else {
            pictureurl=p2.getPictureUrl();
        }
        Map jsonMap=new HashMap();
        jsonMap.put("resident",r2);
        jsonMap.put("communityName",communityName);
        jsonMap.put("permissionName",permissionName);
        jsonMap.put("pictureurl",pictureurl);
        String jsonString= JSONObject.fromObject(jsonMap).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }
    //个人信息修改
    @Action(value = "updatepersonal")
    public void updatePersonal(){
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        Resident resident=new Resident();
        resident.setResidentId(Long.parseLong(request.getParameter("residentId")));
        Resident r=residentService.findResident(resident);
        r.setResidentName(request.getParameter("residentChangeName"));
        r.setResidentCommunity(request.getParameter("residentChangeCommunity"));
        r.setResidentAge(request.getParameter("residentChangeAge"));
        r.setResidentPhone(request.getParameter("residentChangePhone"));
        r.setResidentAdress(request.getParameter("residentChangeAdress"));
        r.setResidentDelete(1);
        residentService.updateResident(r);
    }


    //获取个人信息的评论列表和文章信息
    @Action(value = "getpersonalcommentlist")
    public void getPersonalCommentList() throws IOException{
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        Resident r=(Resident) session.getAttribute("user");
        Resident r1=new Resident();
        r1.setResidentId(r.getResidentId());
        Resident r2=residentService.findResident(r1);
        Comment c=new Comment();
        c.setCommentPersion(r2.getResidentId());
        List<Comment> commentList=commentService.allListComment(c);
        List<Map> mapList=new ArrayList<>();
        for (Comment i:commentList){
            Map map=new HashMap();
            Announcement a=new Announcement();
            a.setAnnouncementId(Long.parseLong(i.getCommentNumber()));
            Announcement a2=announcementService.findAnnouncement(a);
            Picture p=new Picture();
            p.setPictureNumber(i.getCommentPicture());
            List<Picture> pictureList1=pictureService.allListPicture(p);
            p.setPictureNumber(a2.getAnnouncementPicture());
            List<Picture> pictureList2=pictureService.allListPicture(p);
            map.put("announcement",a2);
            map.put("comment",i);
            map.put("commentPicture",pictureList1);
            map.put("announcementPicture",pictureList2);
            mapList.add(map);
        }
        String jsonString= JSONArray.fromObject(mapList).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }


    //获取个人信息的公告和公告的pinglun
    @Action(value = "getpersonalannouncementlist")
    public void getPersonalAnnouncementList() throws IOException{
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        Resident r=(Resident) session.getAttribute("user");
        Resident r1=new Resident();
        r1.setResidentId(r.getResidentId());
        Resident r2=residentService.findResident(r1);
        Announcement a=new Announcement();
        a.setAnnouncementPersion(r2.getResidentId());
        List<Announcement> announcementList=announcementService.allListAnnouncement(a);
        List<Map> mapList=new ArrayList<>();
        for (Announcement i:announcementList){
            Map map=new HashMap();
            Comment c=new Comment();
            c.setCommentNumber(i.getAnnouncementId().toString());
            List<Comment> commentList=commentService.allListComment(c);
            Picture p=new Picture();
            p.setPictureNumber(i.getAnnouncementPicture());
            List<Picture> pictureList1=pictureService.allListPicture(p);
            List<Map> mapList1=new ArrayList<>();
            for (Comment j:commentList){
                Picture p2=new Picture();
                p2.setPictureNumber(j.getCommentPicture());
                List<Picture> pictureList2=pictureService.allListPicture(p2);
                Resident r3=new Resident();
                r3.setResidentId(j.getCommentPersion());
                Resident r4=residentService.findResident(r3);
                Picture p3=new Picture();
                p3.setPictureNumber(r4.getResidentAvatar());
                Picture p4=pictureService.findPicture(p3);
                if (p4==null){
                    p4=new Picture();
                    p4.setPictureUrl("/nothing.jpg");
                }
                Map map1=new HashMap();
                map1.put("commentPicturelist",pictureList2);
                map1.put("comment",j);
                map1.put("resident",r4);
                map1.put("picture",p4);
                mapList1.add(map1);
            }
            map.put("announcement",i);
            map.put("commentlist",mapList1);
            map.put("announcementPicture",pictureList1);
            mapList.add(map);
        }
        String jsonString= JSONArray.fromObject(mapList).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }

    @Action(value = "deletepersonalcomment")
    public void DeletePersonalComment(){
        HttpServletRequest request= ServletActionContext.getRequest();
        String id=request.getParameter("id");
        Comment c=new Comment();
        c.setCommentId(Long.parseLong(id));
        commentService.deleteComment(c);
    }

    @Action(value = "deletepersonalannouncement")
    public void DeletePersonalAnnouncement(){
        HttpServletRequest request= ServletActionContext.getRequest();
        String id=request.getParameter("id");
        Announcement a=new Announcement();
        a.setAnnouncementId(Long.parseLong(id));
        Announcement a1=announcementService.findAnnouncement(a);
        Comment c=new Comment();
        c.setCommentNumber(a1.getAnnouncementId().toString());
        List<Comment> commentList=commentService.allListComment(c);
        for (Comment i:commentList){
            commentService.deleteComment(i);
        }
        announcementService.deleteAnnouncement(a);
    }

    @Action(value = "getpersonalhead")
    public void gtePersonalHead() throws IOException{
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        Resident r=(Resident) session.getAttribute("user");
        Resident r1=new Resident();
        r1.setResidentId(r.getResidentId());
        Resident r2=residentService.findResident(r1);
        Picture p=new Picture();
        p.setPictureNumber(r2.getResidentAvatar());
        List<Picture> pictureList=pictureService.allListPicture(p);
        Picture p2=new Picture();
        for (Picture i:pictureList){
            p2=i;
        }
        if (p2==null){
            p2=new Picture();
            p2.setPictureUrl("/noting.jpg");
        }
        Community c=new Community();
        c.setCommunityId(Long.parseLong(r2.getResidentCommunity()));
        Community c2=communityService.findCommunity(c);
        Map map=new HashMap();
        map.put("resident",r2);
        map.put("picture",p2);
        map.put("community",c2);
        String jsonString= JSONObject.fromObject(map).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }
}
