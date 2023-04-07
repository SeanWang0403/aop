package com.sean.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Order(1) //aop預設根據字母排序順序執行，使用order可以決定順序，數字越小越先執行
@Component
@Aspect
public class AnnotationSomeThingAop {
    @Pointcut("@annotation(com.sean.aop.annotation.DoSomethingAnnotation)")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void runBefore(JoinPoint joinPoint) {
        System.out.println("Annotation do something aop before");
    }

    @Around("pointCut()")
    public Object runAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("Annotation do something aop around start");
        Object[] args = point.getArgs();
        Object result = point.proceed(args);
        System.out.println("Annotation do something aop around finish");
        return result;
    }

    @AfterReturning("pointCut()")
    public void runAfterRunning(JoinPoint joinPoint) {
        System.out.println("Annotation do something aop after running");
    }

    @AfterThrowing("pointCut()")
    public void runAfterThrowing(JoinPoint joinPoint) {
        System.out.println("Annotation do something aop after throwing");
    }

    @After("pointCut()")
    public void runAfter(JoinPoint joinPoint) {
        System.out.println("Annotation do something aop after");
    }
}
