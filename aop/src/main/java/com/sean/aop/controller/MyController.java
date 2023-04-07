package com.sean.aop.controller;

import com.sean.aop.annotation.DoSomethingAnnotation;
import com.sean.aop.annotation.LogAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/pointcut_single_success")
    public String aopSinglePointcutSuccess() {
        System.out.println("Single Pointcut Success");
        return "Single Pointcut Success";
    }

    @GetMapping("/pointcut_single_exception")
    public String aopSinglePointcutException() {
        System.out.println("Single Pointcut Exception");
        Object object = null;
        object.toString();
        return "Single Pointcut Exception";
    }

    @GetMapping("/pointcut_multiple_success")
    public String aopMultiplePointcutSuccess() {
        System.out.println("Multiple Pointcut Success");
        return "Multiple Pointcut Success";
    }

    @GetMapping("/pointcut_multiple_exception")
    public String aopMultiplePointcutException() {
        System.out.println("Multiple Pointcut Exception");
        Object object = null;
        object.toString();
        return "Multiple Pointcut Exception";
    }

    @LogAnnotation
    @GetMapping("/annotation_single_success")
    public String annotationSingleSuccess() {
        System.out.println("Annotation Single Success");
        return "Annotation Single Success";
    }

    @LogAnnotation
    @GetMapping("/annotation_single_exception")
    public String annotationSingleException() {
        System.out.println("Annotation Single Exception");
        Object object = null;
        object.toString();
        return "Annotation Single Exception";
    }

    @LogAnnotation
    @DoSomethingAnnotation
    @GetMapping("/annotation_multiple_success")
    public String annotationMultipleSuccess() {
        System.out.println("Annotation Multiple Success");
        return "Annotation Multiple Success";
    }


    @LogAnnotation
    @DoSomethingAnnotation
    @GetMapping("/annotation_multiple_exception")
    public String annotationMultipleException() {
        System.out.println("Annotation Multiple Exception");
        Object object = null;
        object.toString();
        return "Annotation Multiple Exception";
    }

}
