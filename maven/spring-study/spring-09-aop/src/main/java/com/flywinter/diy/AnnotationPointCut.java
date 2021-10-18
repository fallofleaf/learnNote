package com.flywinter.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/27 1:02
 * Description:使用注解方式实现AOP
 */
@Aspect//标注这个类是一个切面
public class AnnotationPointCut {

    @Before("execution(* com.flywinter.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("方法执行前");
    }
    @After("execution(* com.flywinter.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("方法执行后");
    }
    //在环绕增强中 我们可以给定一个参数，代表我们要获取处理切入的点
    @Around("execution(* com.flywinter.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
        Signature signature = joinPoint.getSignature();
        System.out.println("获得的签名为:"+signature);
        //执行方法
        Object proceed = joinPoint.proceed();
        System.out.println("环绕");
    }

}
