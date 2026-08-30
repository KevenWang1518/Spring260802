package com.wyjun.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//切面类
@Component //切面也是一个Bean，也需要纳入IoC容器的管理。
@Aspect //用这个注解用来声明一个切面。

public class SecurityLogAspect { //进行操作日志的记录

    //需求:日志的记录
    //记录的是 saveXxx、deleteXxx、modifyXxx
    //选择哪个通知呢?后置通知，确实执行过了进行记录。

    //定义统一的切点表达式，只针对增删改添加事务，不包括查询事务。
    @Pointcut("execution(* com.wyjun..*.save*(..))")
    public void saveJoinPoint() {
    }

    @Pointcut("execution(* com.wyjun..*.delete*(..))")
    public void deleteJoinPoint() {
    }

    @Pointcut("execution(* com.wyjun..*.modify*(..))")
    public void modifyJoinPoint() {
    }

    // 环绕通知
    @After("saveJoinPoint()||deleteJoinPoint()||modifyJoinPoint()") //用方法名代替切点表达式
    public void afterAdvice(JoinPoint joinPoint) { //joinPoint通过它可以得到类的信息以及方法的信息。
        // 获取系统当前时间
        LocalDateTime nowTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        String strNowtime = nowTime.format(dtf);

        // 返回一个方法的签名对象
        System.out.println(strNowtime + " 操作员执行了" + joinPoint.getSignature().getDeclaringTypeName() + "`s " + joinPoint.getSignature().getName() + "()");
    }
}
