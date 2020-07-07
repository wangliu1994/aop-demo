package com.winnnie.aopdemo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author winnie [wangliu023@qq.com]
 * @date 2020/7/7
 */
@Component
@Slf4j
@Aspect
public class AopConfig {

    @Pointcut("execution(public * com.winnnie.aopdemo.HelloController.hello(..))")
    public void hello(){}

    @Before("hello()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        log.info("开始之前");
    }

    @AfterReturning(returning = "obj",pointcut = "hello()")
    public void doAfterReturning(Object obj) throws Throwable {
        log.info("开始之后");
    }

    @AfterThrowing(value = "hello()",throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint,Throwable exception){
        log.info("抛出异常");
    }

    @Around(value = "hello()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("方法执行全过程");
        return proceedingJoinPoint.proceed();
    }
}
