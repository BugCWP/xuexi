package com.test;

import com.opensymphony.xwork2.ActionSupport;

public class test4Action extends ActionSupport {
    @Override
    public String execute() throws Exception {
        System.out.println("test4Action的execute执行");
        return SUCCESS;
    }
}
