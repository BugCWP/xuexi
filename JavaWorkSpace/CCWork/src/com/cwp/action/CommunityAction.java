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

    @Action()
    public String listCommunity(){

        return SUCCESS;
    }

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
        String pageIndex=request.getParameter("pageIndex");
        String communityTitle=request.getParameter("communityTitle");
        System.out.println(pageIndex+","+communityTitle);
        Page page=new Page();
        Community c=new Community();
        page.setPageIndex(Integer.parseInt(pageIndex));
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
        HttpServletResponse response=ServletActionContext.getResponse();
        Long count=communityService.findTotalCommunity(community);
        Map jsonMap=new HashMap();
        jsonMap.put("communityTotalCount",count);
        String jsonString= JSONObject.fromObject(jsonMap).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }

    @Override
    public Community getModel() {
        return community;
    }
}
