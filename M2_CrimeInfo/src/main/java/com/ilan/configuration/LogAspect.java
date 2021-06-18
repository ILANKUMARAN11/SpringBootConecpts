package com.ilan.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
@Slf4j
public class LogAspect {


    @Before("execution( * com.ilan.controller.*.*(..)) || "+
            "execution( * com.ilan.service.*.*(..)) || "+
            "execution( * com.ilan.repository.*.*(..))")
    public void logArguments(JoinPoint joinPoint){
        String kind = joinPoint.getKind();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("{}.{}.{}() args {}",kind,className,methodName,args);
    }


    @AfterReturning(pointcut = "execution( * com.ilan.controller.*.*(..)) || "+
                                "execution( * com.ilan.service.*.*(..)) || "+
                                "execution( * com.ilan.repository.*.*(..))"
                                ,returning = "returnValue")
    public void logReturnValue(JoinPoint joinPoint, Object returnValue){
        String kind = joinPoint.getKind();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        log.info("{}.{}.{}() return Value {}",kind,className,methodName,returnValue);
    }



}
