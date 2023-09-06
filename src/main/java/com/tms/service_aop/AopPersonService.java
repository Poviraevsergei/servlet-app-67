package com.tms.service_aop;

import org.springframework.stereotype.Component;

@Component
public class AopPersonService {

    public String getHelloMessage() {
        for (int i = 0; i < 1000_000; i++) {

        }
        return "Hello message";
    }
}
