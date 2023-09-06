package com.tms.service_aop;

import org.springframework.stereotype.Component;

@Component
public class AopPersonService {

    public String getHelloMessage(String x, Integer y) {
        for (int i = 0; i < 1000_000; i++) {

        }
        return "Hello message";
    }
}
