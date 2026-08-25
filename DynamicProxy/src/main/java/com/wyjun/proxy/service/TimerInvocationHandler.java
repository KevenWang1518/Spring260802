package com.wyjun.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//调用处理器必须实现调用处理器接口。
//整个系统中只需要编写一个用于计时的调用处理器。
public class TimerInvocationHandler implements InvocationHandler {

    //目标对象
    private Object target;

    //构造方法给target赋值
    public TimerInvocationHandler(Object target) {
        this.target = target;
    }


    //这个就是那个回调方法。
    //这个回调什么时候执行?
    //在代理对象调用代理方法的时候，以下的invoke回调会被自动调用。

    /*
    关于调用处理器invoke方法中的3个参数:
    第一个参数:Object proxy
        invoke方法被调用的时候，自动给我们传递过来了代理对象的引用。
    第二个参数:Method method
        目标对象上的目标方法。
    第三个参数:Object[] args
        目标方法上的参数。

    重点：有了method + args这些参数，就可以调用目标对象上的目标方法了。
    */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //前增强，计时代码也只需要写一次。
        long startTime = System.currentTimeMillis();

        //核心业务代码（执行目标对象上的目标方法），也就是原有的基础功能
        Object retValue = method.invoke(target, args);

        //后增强，计时代码也只需要写一次。
        long endTime = System.currentTimeMillis();
        String className = target.getClass().getName();//反射获取类名
        String methodName = method.getName();//反射获取方法名
        System.out.println(className + "'s " + methodName + "() running : " + (endTime - startTime)+"ms");

        return retValue;
    }
}
