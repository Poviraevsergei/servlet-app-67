package com.tms;

import com.tms.domain.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //1. IoC контейнер
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-setting.xml");
        Person person = (Person) context.getBean("person-c67");
        System.out.println(person);
    }
}
