package com.zc.cris.bean;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalculatorLogAspect {

    // 抽取公共的切点表达式
    // 1. 本类引用；2. 其他类引用
    @Pointcut("execution(public Integer com.zc.cris.bean.Calculator.*(..))")
    public void pointCut() {};
    
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println(""+joinPoint.getSignature().getName()+"准备运行，执行参数是：{"+Arrays.asList(joinPoint.getArgs())+"}");
    }
    
    @After("com.zc.cris.bean.CalculatorLogAspect.pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(""+joinPoint.getSignature().getName()+"执行结束...");
    }
    
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(""+joinPoint.getSignature().getName()+"正常返回，运行结果是：{"+result+"}");
    }
    
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logReturnException(JoinPoint joinPoint, Exception exception) {
        System.out.println(""+joinPoint.getSignature().getName()+"异常，异常信息：{"+exception+"}");
    }
    
}
