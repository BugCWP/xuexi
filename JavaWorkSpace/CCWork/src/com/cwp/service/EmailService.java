package com.cwp.service;

import com.cwp.entity.Resident;

public interface EmailService {
    //发送邮件
    boolean sendEmail(Resident resident,String password);
}
