package com.cwp.action;

import com.cwp.entity.Announcement;
import com.cwp.entity.Comment;
import com.cwp.entity.Community;
import com.cwp.entity.Resident;
import com.cwp.listener.LoginUserListener;
import com.cwp.service.AnnouncementService;
import com.cwp.service.CommentService;
import com.cwp.service.CommunityService;
import com.cwp.service.ResidentService;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ParentPackage("struts-default")
@Namespace("/controlpanel")
@Results(@Result(name = "500",type = "dispatcher",location = "/500.jsp"))
public class controlpanelAction extends ActionSupport {

    @Autowired
    private ResidentService residentService;

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommunityService communityService;

    //获取展示面板信息
    @Action(value = "controlnumber")
    public void controlnumber() throws IOException{
        List<Resident> onlineResident=LoginUserListener.residentList;
//        在线人数
        Integer onlineResidentCount=0;
        for (Resident resident:onlineResident){
            onlineResidentCount++;
        }
//        System.out.println(onlineResidentCount);
//        今日访问量
        Integer onlineResidentCountToday=LoginUserListener.onlineResidentCountToday;
//        System.out.println(onlineResidentCountToday);
//        获取用户数
        Long residentCount=residentService.findTotalCount(new Resident());
//        System.out.println(residentCount);
//        获取公告数
        Long announcementCount=announcementService.findTotalCount(new Announcement());
//        System.out.println(announcementCount);
//        获取评论数
        Long commentCount=commentService.findTotalComment(new Comment());
//        System.out.println(commentCount);
//        获取社区数
        Long communityCount=communityService.findTotalCommunity(new Community());
//        System.out.println(communityCount);
        Map jsonMap=new HashMap();
        jsonMap.put("onlineResidentCount",onlineResidentCount);
        jsonMap.put("onlineResidentCountToday",onlineResidentCountToday);
        jsonMap.put("residentCount",residentCount);
        jsonMap.put("announcementCount",announcementCount);
        jsonMap.put("commentCount",commentCount);
        jsonMap.put("communityCount",communityCount);
        HttpServletResponse response= ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String jsonString= JSONObject.fromObject(jsonMap).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }
}
