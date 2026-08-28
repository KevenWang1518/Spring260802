package com.wyjun.proxy.service;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    //动态添加计时的代码。
    public static Object getProxyForTimer(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (Object proxyObj, Method method, Object[] args) -> {

            //前增强，计时代码也只需要写一次。
            long startTime = System.currentTimeMillis();

            //核心业务代码（执行目标对象上的目标方法），也就是原有的基础功能
            Object retValue = method.invoke(target, args);

            //后增强，计时代码也只需要写一次。
            long endTime = System.currentTimeMillis();
            String className = target.getClass().getName();//反射获取类名
            String methodName = method.getName();//反射获取方法名
            System.out.println(className + "'s " + methodName + "() running : " + (endTime - startTime) + "ms");

            return retValue;
        });
    }

    //动态添加事务的代码。
    public static Object getProxyForTransaction(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (Object proxyObj, Method method, Object[] args) -> {
            Object retValue = null;
            try {
                //开启事务
                System.out.println("开启事务");
                // 执行目标业务方法。
                retValue = method.invoke(target, args);
                //提交事务
            } catch (Exception e) {
                System.out.println("提交事务");
                //遇到异常回滚事务。
                System.out.println("回滚事务");
            }
            return retValue;
        });
    }
}
