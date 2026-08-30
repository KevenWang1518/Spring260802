package com.wyjun.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Random;

//切面类
@Component //切面也是一个Bean，也需要纳入IoC容器的管理。
@Aspect //用这个注解用来声明一个切面。

public class TransactionAspect {

    //定义统一的切点表达式，只针对增删改添加事务。
    @Pointcut("execution(* com.wyjun..*.save*(..))")
    public void saveJoinPoint() {
    }

    @Pointcut("execution(* com.wyjun..*.delete*(..))")
    public void deleteJoinPoint() {
    }

    @Pointcut("execution(* com.wyjun..*.update*(..))")
    public void updateJoinPoint() {
    }

    // 环绕通知
    @Around("saveJoinPoint()||deleteJoinPoint()||updateJoinPoint()") //用方法名代替切点表达式
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {

        Object retObject = null;

        try {
            System.out.println("开启事务");
            retObject = proceedingJoinPoint.proceed();//调用目标对象目标方法
            System.out.println("提交事务");
        } catch (Throwable e) {
            System.out.println("回滚事务");
            throw new RuntimeException(e);
        }

        return retObject;
    }

}
