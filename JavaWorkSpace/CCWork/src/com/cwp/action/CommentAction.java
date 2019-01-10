package com.cwp.action;

import com.cwp.entity.Announcement;
import com.cwp.entity.Comment;
import com.cwp.entity.Page;
import com.cwp.entity.Resident;
import com.cwp.service.AnnouncementService;
import com.cwp.service.CommentService;
import com.cwp.service.ResidentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
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
import java.text.SimpleDateFormat;
import java.util.*;

@ParentPackage("struts-default")
@Namespace("/comment")
@Results(@Result(name = "500",type = "dispatcher",location = "/500.jsp"))
public class CommentAction extends ActionSupport implements ModelDriven<Comment> {
   private Comment comment=new Comment();

   @Autowired
   private CommentService commentService;
   @Autowired
   private AnnouncementService announcementService;
   @Autowired
   private ResidentService residentService;
//获取评论数量
   @Action(value = "commentTotalCount")
   public void getCommentTotalCount() throws IOException {
       HttpServletRequest request= ServletActionContext.getRequest();
       HttpServletResponse response=ServletActionContext.getResponse();
       response.setContentType("text/html;charset=utf-8");
       String commentFindType =request.getParameter("commentFindType");
       String commentText =request.getParameter("commentText");
       String commentDeleteOrStay =request.getParameter("commentDeleteOrStay");
       Comment c=new Comment();
       if (!"".equals(commentFindType)){
           if ("announcementTitle".equals(commentFindType)){
               Announcement a=new Announcement();
               a.setAnnouncementTitle(commentText);
               Announcement a2=announcementService.findAnnouncement(a);
               c.setCommentNumber(a2.getAnnouncementId().toString());
           }
           if ("commentTime".equals(commentFindType)){
               c.setCommentTime(commentText);
           }
           if ("commentResident".equals(commentFindType)){
               Resident r=new Resident();
               r.setResidentName(commentText);
               Resident r2=residentService.findResident(r);
               c.setCommentPersion(r2.getResidentId());
           }
       }
       c.setCommentDelete(Integer.parseInt(commentDeleteOrStay));
       Long count=commentService.findTotalComment(c);
       Map map=new HashMap();
       map.put("commentTotalCount",count);
       String jsonString= JSONObject.fromObject(map).toString();
       PrintWriter out=response.getWriter();
       out.println(jsonString);
       out.flush();
       out.close();
   }

   //分页获取评论表对列
    @Action(value = "listcommentbypage")
    public void getListCommentByPage() throws IOException{
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String commentFindType =request.getParameter("commentFindType");
        String commentText =request.getParameter("commentText");
        String commentDeleteOrStay =request.getParameter("commentDeleteOrStay");
        String commentPageIndex =request.getParameter("commentPageIndex");
        String commentPageSize =request.getParameter("commentPageSize");
        Comment c=new Comment();
        if (!"".equals(commentFindType)){
            if ("announcementTitle".equals(commentFindType)){
                Announcement a=new Announcement();
                a.setAnnouncementTitle(commentText);
                Announcement a2=announcementService.findAnnouncement(a);
                c.setCommentNumber(a2.getAnnouncementId().toString());
            }
            if ("commentTime".equals(commentFindType)){
                c.setCommentTime(commentText);
            }
            if ("commentResident".equals(commentFindType)){
                Resident r=new Resident();
                r.setResidentName(commentText);
                Resident r2=residentService.findResident(r);
                c.setCommentPersion(r2.getResidentId());
            }
        }
        c.setCommentDelete(Integer.parseInt(commentDeleteOrStay));
        Page page=new Page();
        page.setPageSize(Integer.parseInt(commentPageSize));
        page.setPageIndex(Integer.parseInt(commentPageIndex));
        List<Comment> commentList=commentService.listComment(c,page);
        List<Map> mapList=new ArrayList<>();
        for (Comment i:commentList){
            Resident r1=new Resident();
            r1.setResidentId(i.getCommentPersion());
            Resident r2=residentService.findResident(r1);
            Announcement a1=new Announcement();
            a1.setAnnouncementId(Long.parseLong(i.getCommentNumber()));
            Announcement a2=announcementService.findAnnouncement(a1);
            Map map=new HashMap();
            map.put("comment",i);
            map.put("residentName",r2.getResidentName());
            map.put("announcementTitle",a2.getAnnouncementTitle());
            mapList.add(map);
        }
        String jsonString= JSONArray.fromObject(mapList).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }
//删除
    @Action(value = "deletecomment")
    public void DeleteComment(){
        HttpServletRequest request= ServletActionContext.getRequest();
        String id=request.getParameter("id");
        Comment c=new Comment();
        c.setCommentId(Long.parseLong(id));
        commentService.deleteComment(c);
    }

//解冻
    @Action(value = "commentjiebtn")
    public void CommentJieBtn(){
        HttpServletRequest request= ServletActionContext.getRequest();
        String id=request.getParameter("id");
        Comment c=new Comment();
        c.setCommentId(Long.parseLong(id));
        Comment c2=commentService.findComment(c);
        c2.setCommentDelete(1);
        commentService.updateComment(c2);
    }

    //查找单个评论
    @Action(value = "findcomment")
    public void getFindComment()throws IOException{
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String id=request.getParameter("id");
        Comment c=new Comment();
        Announcement a=new Announcement();
        Resident r=new Resident();
        c.setCommentId(Long.parseLong(id));
        Comment c2=commentService.findComment(c);
        a.setAnnouncementId(Long.parseLong(c2.getCommentNumber()));
        r.setResidentId(c.getCommentPersion());
        Resident r2=residentService.findResident(r);
        Announcement a2=announcementService.findAnnouncement(a);
        Map jsonMap=new HashMap();
        jsonMap.put("comment",c2);
        jsonMap.put("commentannouncement",a2.getAnnouncementTitle());
        jsonMap.put("commentresident",r2.getResidentName());
        String jsonString=JSONObject.fromObject(jsonMap).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
   }

   @Action(value = "addcomment")
   public void AddComment(){
       HttpServletRequest request= ServletActionContext.getRequest();
       HttpServletResponse response=ServletActionContext.getResponse();
       response.setContentType("text/html;charset=utf-8");
       String text=request.getParameter("text");
       String id=request.getParameter("id");
       Comment c=new Comment();
       c.setCommentNumber(id);
       HttpSession session=request.getSession();
       Resident r=(Resident) session.getAttribute("user");
       c.setCommentPersion(r.getResidentId());
       c.setCommentTable(text);
       SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
       String time=ft.format(new Date());
       c.setCommentTime(time);
       commentService.addComment(c);
   }

    @Override
    public Comment getModel() {
        return comment;
    }
}
