package com.tms.service_aop;

import com.tms.aop.MyFirstTimeAnnotation;
import org.springframework.stereotype.Component;

@Component
public class AopPersonService {

    @MyFirstTimeAnnotation
    public String getHelloMessage() {
        for (int i = 0; i < 1000_000; i++) {

        }
        return "Hello message";
    }
}