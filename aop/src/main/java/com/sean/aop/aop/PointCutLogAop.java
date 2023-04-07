package com.sean.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Order(2) //aop預設根據字母排序順序執行，使用order可以決定順序，數字越小越先執行
@Component
@Aspect
public class PointCutLogAop {
    @Pointcut("execution(* com.sean.aop.controller.*.aop*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void runBefore(JoinPoint joinPoint) throws IOException {
        System.out.println("Log aop before");
    }

    @Around("pointCut()")
    public Object runAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("Log aop around start");
        Object[] args = point.getArgs();
        Object result = point.proceed(args);
        System.out.println("Log aop around finish");
        return result;
    }

    @AfterReturning("pointCut()")
    public void runAfterRunning(JoinPoint joinPoint) {
        System.out.println("Log aop after running");
    }

    @AfterThrowing("pointCut()")
    public void runAfterThrowing(JoinPoint joinPoint) {
        System.out.println("Log aop after throwing");
    }

    @After("pointCut()")
    public void runAfter(JoinPoint joinPoint) throws IOException {
        System.out.println("Log aop after");
    }
}
