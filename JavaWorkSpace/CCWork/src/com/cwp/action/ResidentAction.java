package com.cwp.action;

import com.cwp.entity.Community;
import com.cwp.entity.Page;
import com.cwp.entity.Resident;
import com.cwp.service.CommunityService;
import com.cwp.service.EmailService;
import com.cwp.service.GenerateNewPasswordService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ParentPackage("struts-default")
@Namespace("/resident")
@Results({@Result(name ="500",type = "dispatcher",location = "/500.jsp")})
public class ResidentAction extends ActionSupport implements ModelDriven<Resident> {
    private Resident resident=new Resident();

    @Autowired
    private ResidentService residentService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private GenerateNewPasswordService generateNewPasswordService;

    @Autowired
    private CommunityService communityService;

    //注册接口
    @Action(value = "register",results = {@Result(name = "success",type = "redirect",location = "/login.jsp")})
    public String registerResident(){
        boolean flag=residentService.addResident(resident);
        return SUCCESS;
    }

    //登陆接口
    @Action(value = "login",results = {@Result(name = "success",type = "redirect",location = "/Home.jsp"),
    @Result(name = "login",type = "dispatcher",location = "/login.jsp")})
    public String loginResident(){
        Resident r=residentService.loginResident(resident);
        HttpServletRequest request= ServletActionContext.getRequest();
        if (r==null){
            request.setAttribute("msg","邮箱或密码错误");
            return "login";
        }else {
            HttpSession session=request.getSession();
            session.setAttribute("user",r);
            return SUCCESS;
        }
    }

    //忘记密码接口
    @Action(value = "forgetpwd",results = {@Result(name = "success",type = "dispatcher",location = "/login.jsp"),
    @Result(name = "noresidentAccount",type = "dispatcher",location = "/forgetPassword.jsp"),
    @Result(name = "nosendEmail",type = "dispatcher",location = "/forgetPassword.jsp")})
    public String forgetPassword(){
        Resident r=residentService.findResident(resident);
        HttpServletRequest request=ServletActionContext.getRequest();
        if (r!=null){
            String newPassword=generateNewPasswordService.generateNewPassword();
            if (emailService.sendEmail(r,newPassword)){
                 r.setResidentPassword(newPassword);
                 residentService.updateResident(r);
                 return SUCCESS;
            }else {
                request.setAttribute("noAccount","发送邮件失败，请重试");
                 return "nosendEmail";
            }
        }else {
            request.setAttribute("noAccount","请输入已注册用户的邮箱地址");
            return "noresidentAccount";
        }
    }

    //退出接口
    @Action(value = "loginout",results = {@Result(name = "success",type ="redirect",location = "/login.jsp")})
    public String loginOut(){
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        session.removeAttribute("user");
        return SUCCESS;
    }

    //获取居民数量接口
    @Action(value = "getresidenttotalcount")
    public void getResidentTotalCount() throws IOException {
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String communityId=request.getParameter("residentCommunity");
        String residentFindType=request.getParameter("residentFindType");
        String residentText=request.getParameter("residentText");
        String residentDelete=request.getParameter("residentDelete");
        Resident r=new Resident();
        if (!"".equals(communityId)){
           r.setResidentCommunity(communityId);
        }
        if (!"".equals(residentDelete)){
            r.setResidentDelete(Integer.parseInt(residentDelete));
        }
        if (!"".equals(residentFindType)){
            if ("residentName".equals(residentFindType)){
                System.out.println(residentFindType+":"+residentText);
                r.setResidentName(residentText);
            }else if ("residentAge".equals(residentFindType)){
                r.setResidentAge(residentText);
            }else if ("residentEmaill".equals(residentFindType)){
                r.setResidentAccount(residentText);
            }else if ("residentPhone".equals(residentFindType)){
                r.setResidentPhone(residentText);
            }else if("residentAdress".equals(residentFindType)){
                r.setResidentAdress(residentText);
            }
        }
        System.out.println(r.getResidentDelete());
        Long count=residentService.findTotalCount(r);
        Map jsonMap=new HashMap();
        jsonMap.put("residentTotalCount",count);
        String jsonString= JSONObject.fromObject(jsonMap).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }

    //分页查询用户队列
    @Action(value = "listresidentByPage")
    public void getListResidentByPage() throws IOException{
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String communityId=request.getParameter("residentCommunity");
        String residentFindType=request.getParameter("residentFindType");
        String residentText=request.getParameter("residentText");
        String residentPageIndex=request.getParameter("residentPageIndex");
        String residentPageSize=request.getParameter("residentPageSize");
        String residentDelete=request.getParameter("residentDelete");
        Resident r=new Resident();
        Page page=new Page();
        if (!"".equals(communityId)){
            r.setResidentCommunity(communityId);
        }
        if (!"".equals(residentDelete)){
            r.setResidentDelete(Integer.parseInt(residentDelete));
        }
        if (!"".equals(residentFindType)){
            if ("residentName".equals(residentFindType)){
                System.out.println(residentFindType+":"+residentText);
                r.setResidentName(residentText);
            }else if ("residentAge".equals(residentFindType)){
                r.setResidentAge(residentText);
            }else if ("residentEmaill".equals(residentFindType)){
                r.setResidentAccount(residentText);
            }else if ("residentPhone".equals(residentFindType)){
                r.setResidentPhone(residentText);
            }else if("residentAdress".equals(residentFindType)){
                r.setResidentAdress(residentText);
            }
        }
        page.setPageSize(Integer.parseInt(residentPageSize));
        page.setPageIndex(Integer.parseInt(residentPageIndex));
        List<Resident> residentList=residentService.listResident(r,page);
        List<Map> mapList=new ArrayList<>();
        for (Resident i:residentList){
            Community c=new Community();
            c.setCommunityId(Long.parseLong(i.getResidentCommunity()));
            String communityName=communityService.findCommunity(c).getCommunityName();
            Map map=new HashMap();
            map.put("resident",i);
            map.put("communityName",communityName);
            mapList.add(map);
        }
        String jsonString= JSONArray.fromObject(mapList).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }
    //删除接口
    @Action(value = "deleteresident")
    public void DeleteResident(){
        HttpServletRequest request=ServletActionContext.getRequest();
        String id=request.getParameter("id");
        Resident r=new Resident();
        r.setResidentId(Long.parseLong(id));
        residentService.deleteResident(r);
    }
    //修改接口1
    @Action(value = "updateresidentbydelete")
    public void UpdateResidentByDelete(){
        HttpServletRequest request=ServletActionContext.getRequest();
        String id=request.getParameter("id");
        Resident r=new Resident();
        r.setResidentId(Long.parseLong(id));
        Resident r2=residentService.findResident(r);
        r2.setResidentDelete(1);
        residentService.updateResident(r2);
    }

    //修改接口2
    @Action(value = "updateresident")
    public void UpdateResident(){
        HttpServletRequest request=ServletActionContext.getRequest();
        String changecommunityId=request.getParameter("changecommunityId");
        String residentchangePhone=request.getParameter("residentchangePhone");
        String residentchangeAdress=request.getParameter("residentchangeAdress");
        String residentId=request.getParameter("residentId");
        Resident r1=new Resident();
        r1.setResidentId(Long.parseLong(residentId));
        Resident r2=residentService.findResident(r1);
        r2.setResidentPhone(residentchangePhone);
        r2.setResidentAdress(residentchangeAdress);
        r2.setResidentCommunity(changecommunityId);
        residentService.updateResident(r2);
    }

    //数组信息
    //单条信息
    @Action(value = "findresident")
    public void FindResident() throws IOException{
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String id=request.getParameter("id");
        Resident r=new Resident();
        r.setResidentId(Long.parseLong(id));
        Resident r2=residentService.findResident(r);
        Map map=new HashMap();
        map.put("resident",r2);
        String jsonString=JSONObject.fromObject(map).toString();
        PrintWriter out=response.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }
    @Override
    public Resident getModel() {
        return resident;
    }
}
