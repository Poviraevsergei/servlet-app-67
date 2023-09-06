package com.tms;

import com.tms.domain.Person;
import com.tms.service_aop.AopPersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Main {
    public static void main(String[] args) {
        //1. IoC контейнер
        ApplicationContext context = new AnnotationConfigApplicationContext("com.tms");
        AopPersonService aps = (AopPersonService) context.getBean("aopPersonService");
        aps.getHelloMessage();
    }
}
