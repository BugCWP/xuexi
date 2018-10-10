package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWordaction extends ActionSupport {
    private String name;
    @Override
    public String execute() throws Exception {
        
        return super.execute();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
