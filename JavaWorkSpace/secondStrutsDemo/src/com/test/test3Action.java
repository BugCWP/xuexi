package com.test;


import com.opensymphony.xwork2.Action;

public class test3Action implements Action {
    @Override
    public String execute() {
        System.out.println("test3Action中的execute执行");
        return SUCCESS;
    }
}
