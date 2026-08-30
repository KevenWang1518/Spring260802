package com.wyjun.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

//切面类
@Component //切面也是一个Bean，也需要纳入IoC容器的管理。
@Aspect //用这个注解用来声明一个切面。

public class MyAspect3 {
    // 编写通知(通知的方法参数上有一个叫做连接点对象，spring框架会自动注入。你可以写，也可以选择忽略。)
    //public void beforeAdvice(JoinPoint joinPoint) {}

    //定义统一的切点表达式
    @Pointcut("execution(* com.wyjun..*.*(..))")
    public void myJoinPoint() {
    }

    // 环绕通知
    @Around("myJoinPoint()") //用方法名代替切点表达式
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("MyAspect2环绕通知开始");

        // 调用目标(控制目标/以及是否调用目标，环绕通知都是可以控制的）。
        Object retObject = null;
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println("random Number is " + randomNumber);
        if (randomNumber > 5) {//通过判断随机数大小，控制目标是否调用
            try {
                //调用目标方法，将返回值返回。
                retObject = proceedingJoinPoint.proceed();
            } catch (Throwable e) {
                //若有异常，则回滚事务
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("MyAspect2目标对象的目标方法未执行!!!");
        }

        System.out.println("MyAspect2环绕通知结束");

        // 这个结果需要返回，如果不返回，当调用目标对象的目标方法时，拿不到返回值(或者目标对象的目标方法返回nuLl)
        return retObject;
    }

    // 前置通知
    @Before("myJoinPoint()") //用方法名代替切点表达式
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("这是一个MyAspect2前置通知");
    }

    // 后置通知
    // 什么时候执行? 只要目标方法调用了，不管目标方法出异常还是不出现异常，后置通知都会正常执行。
    @After("myJoinPoint()") //用方法名代替切点表达式
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("这是一个MyAspect2后置通知");
    }

    // 返回通知
    @AfterReturning("myJoinPoint()") //用方法名代替切点表达式
    public void afterReturningAdvice(JoinPoint joinPoint) {
        System.out.println("这是一个MyAspect2返回通知");
    }

    // 异常通知
    @AfterThrowing("myJoinPoint()") //用方法名代替切点表达式
    public void afterThrowingAdvice(JoinPoint joinPoint) {
        System.out.println("这是一个MyAspect2异常通知");
    }
}
