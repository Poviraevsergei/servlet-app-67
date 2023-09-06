package com.tms.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Aspect
@Component
public class TimeAspect {

    @Around(value = "@within(com.tms.aop.MyFirstTimeAnnotation)")
    void sendInfoBeforeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        //1. Посмотреть время
        LocalTime startTime = LocalTime.now();

        //2. запустить сам метод
        joinPoint.proceed();

        //3. посмотреть еще раз время и найти разницу
        LocalTime endTime = LocalTime.now();
        int resultTime = endTime.getNano() - startTime.getNano();

        //4. вывести время выполнения
        System.out.println("Method with name " + joinPoint.getSignature().getName() + " worked " + resultTime + " nano seconds ...");
    }

/*    @AfterReturning(value = "within(com.tms.service_aop.*)", returning = "result")
    void sendInfoBeforeMethod(JoinPoint joinPoint, Object result) {
        System.out.println(LocalDate.now() + " " + joinPoint.getSignature().getName());
        System.out.println("result is: " + result);
    }
    @AfterThrowing(value = "within(com.tms.service_aop.*)", throwing = "exception")
    void sendInfoBeforeMethod(JoinPoint joinPoint, Throwable exception) {
        System.out.println(LocalDate.now() + " " + joinPoint.getSignature().getName());
        System.out.println("Me exception: " + exception);
    }

    @Before(value = "within(com.tms.service_aop.*)")
    void sendInfoBeforeMethod(JoinPoint joinPoint) {
        System.out.println(LocalDate.now() + joinPoint.getSignature().getName());
    }*/
}