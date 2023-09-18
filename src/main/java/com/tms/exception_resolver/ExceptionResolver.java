package com.tms.exception_resolver;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionResolver {
    @ExceptionHandler(RuntimeException.class)
    public String exceptionHandlerMethodForRuntimeException(Exception e, Model model) {
        model.addAttribute("result", "We have exception: " + e);
        System.out.println("We have exception: " + e);
        return "jspPage";
    }
}