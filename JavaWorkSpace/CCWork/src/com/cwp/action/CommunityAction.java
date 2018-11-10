package com.cwp.action;

import com.cwp.entity.Community;
import com.cwp.entity.Page;
import com.cwp.service.CommunityService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ParentPackage("struts-default")
@Namespace("/community")
@Results(@Result(name = "500",type = "dispatcher",location = "/500.jsp"))
public class CommunityAction extends ActionSupport implements ModelDriven<Community> {
    private Community community=new Community();

    @Autowired
    private CommunityService communityService;


//    返回社区队列
    @Action(value = "/listAllCommunity")
    public void listAllCommunity() throws IOException {
        HttpServletResponse response= ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        List<Community> communityList=communityService.listAllCommunity(community);
//        Map jsonMap=new HashMap();
//        for (Community c:communityList){
////            jsonMap.put("community",c);
////        }
//        String jsonString= JSONObject.fromObject(communityList).toString();
        String jsonArray= JSONArray.fromObject(communityList).toString();
//        String jsonString=JSONObject.fromObject(jsonMap).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonArray);
        out.flush();
        out.close();
    }

    //分页返回社区队列
    @Action(value = "listCommunityByPage")
    public void getListCommunityByPage() throws IOException{
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String pageIndex=request.getParameter("communityPageIndex");
        String communityTitle=request.getParameter("communityTitle");
        String communitypageSize=request.getParameter("communitypageSize");
        Page page=new Page();
        Community c=new Community();
        page.setPageIndex(Integer.parseInt(pageIndex));
        page.setPageCount(Integer.parseInt(communitypageSize));
        if (communityTitle!=null&&!"".equals(communityTitle)){
            c.setCommunityName(communityTitle);
        }
        List<Community> communityList=communityService.listCommunity(c,page);
        String jsonArray= JSONArray.fromObject(communityList).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonArray);
        out.flush();
        out.close();
    }

    //返回社区的总数量
    @Action(value = "CommunityTotalCount")
    public void getCommunityTotalCount() throws IOException{
        HttpServletRequest request=ServletActionContext.getRequest();
        String communityName=request.getParameter("communityTitle");
        Community c=new Community();
        c.setCommunityName(communityName);
        HttpServletResponse response=ServletActionContext.getResponse();
        Long count=communityService.findTotalCommunity(c);
        Map jsonMap=new HashMap();
        jsonMap.put("communityTotalCount",count);
        String jsonString= JSONObject.fromObject(jsonMap).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }

    //添加社区
    @Action(value = "addCommunity")
    public void AddCommunity(){
        HttpServletRequest request=ServletActionContext.getRequest();
        String communityName=request.getParameter("communityName");
        String communityAdress=request.getParameter("communityAdress");
        String communityIntroduction=request.getParameter("communityIntroduction");
        Community c=new Community();
        c.setCommunityName(communityName);
        c.setCommunityAdress(communityAdress);
        c.setCommunityIntroduction(communityIntroduction);
        communityService.addCommunity(c);
    }

    //删除社区
    @Action(value = "deleteCommunity")
    public void DeleteCommunity(){
        HttpServletRequest request=ServletActionContext.getRequest();
        String id=request.getParameter("id");
        Community c=new Community();
        c.setCommunityId(Long.parseLong(id));
        communityService.deleteCommunity(c);
    }

    //返回单一的社区
    @Action(value = "findcommunity")
    public void findCommunity() throws  IOException{
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String id=request.getParameter("id");
        Community c=new Community();
        c.setCommunityId(Long.parseLong(id));
        Community c2=communityService.findCommunity(c);
        String jsonstring=JSONObject.fromObject(c2).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonstring);
        out.flush();
        out.close();
    }

    //修改社区
    @Action(value = "updatecommunity")
    public void updateCommunity(){
        HttpServletRequest request=ServletActionContext.getRequest();
        String id=request.getParameter("id");
        String communityChangeName=request.getParameter("communityChangeName");
        String communityChangeAdress=request.getParameter("communityChangeAdress");
        String communityChangeIntroduction=request.getParameter("communityChangeIntroduction");
        Community c=new Community();
        c.setCommunityId(Long.parseLong(id));
        c.setCommunityName(communityChangeName);
        c.setCommunityAdress(communityChangeAdress);
        c.setCommunityIntroduction(communityChangeIntroduction);
        c.setCommunityDelete(1);
        communityService.updateCommunity(c);
    }

    @Override
    public Community getModel() {
        return community;
    }
}
