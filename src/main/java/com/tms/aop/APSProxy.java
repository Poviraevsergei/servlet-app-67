package com.tms.aop;

import com.tms.service_aop.AopPersonService;

public class APSProxy {
    AopPersonService aopPersonService;

    void before(){
        System.out.println();
        aopPersonService.getHelloMessage();
        System.out.println();
    }
}
