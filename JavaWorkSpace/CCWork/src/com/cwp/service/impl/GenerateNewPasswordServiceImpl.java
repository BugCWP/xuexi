package com.cwp.service.impl;

import com.cwp.service.GenerateNewPasswordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class GenerateNewPasswordServiceImpl implements GenerateNewPasswordService {
    @Override
    public String generateNewPassword() {
        int i=8;
        StringBuffer sb=new StringBuffer();
        for (int j=0;j<i;j++){
            Random random=new Random();
            Integer a=random.nextInt(10);
            sb.append(a.toString());
        }
        return sb.toString();
    }
}
