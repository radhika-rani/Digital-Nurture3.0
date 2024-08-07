package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.BookService.manageBooks(..))")
    public void logBefore() {
        System.out.println("LoggingAspect: Before method manageBooks()");
    }

    @After("execution(* com.library.service.BookService.manageBooks(..))")
    public void logAfter() {
        System.out.println("LoggingAspect: After method manageBooks()");
    }
}
