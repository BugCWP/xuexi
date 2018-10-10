package com.action;

import com.model.adminModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<adminModel> {
    private adminModel admin=new adminModel();
    public String login(){

    }

    public adminModel getAdmin() {
        return admin;
    }

    public void setAdmin(adminModel admin) {
        this.admin = admin;
    }

    @Override
    public adminModel getModel{
        return admin;
    }
}
