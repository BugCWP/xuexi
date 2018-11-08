package com.cwp.action;

import com.cwp.entity.Resident;
import com.cwp.service.EmailService;
import com.cwp.service.GenerateNewPasswordService;
import com.cwp.service.ResidentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    //删除接口
    //修改接口
    //数组信息
    //单条信息
    @Override
    public Resident getModel() {
        return resident;
    }
}
