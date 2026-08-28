package com.wyjun.Proxy;

import com.wyjun.proxy.service.OrderService;
import com.wyjun.proxy.service.OrderServiceImpl;
import com.wyjun.proxy.service.TimerInvocationHandler;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {
    @Test
    public void dynamicProxyTest() {
        //创建一个目标对象
        OrderService target = new OrderServiceImpl();

        //创建一个代理对象
        //JDK动态代理，会在内存当中动态生成这个代理类。内存中已经存在这个代理类了。
        //以下这个代码不仅是在内存当中生成代理类，同时还会将代理类对象创建出来。做了两件事。

        /*
        重点内容:关于 Proxy.newProxyInstance()方法的三个参数?
        第一个参数:Loader(类加载器)
            将来会在内存当中动态拼接一个class字节码。
            java程序执行有规定，要执行java代码首先要将class字节码加载到JVM当中。
            加载到JVM的时候需要使用类加载器。并且代理类和目标类的类加载器必须使用同一个。
        第二个参数:interfaces(指定代理类要实现的接口。)
            规则:代理类和目标类要实现同一个接口。
            通过这个参数也可以看出来，要使用JDK的动态代理，必须有接口。
        第三个参数:invocationHandler(调用处理器)
            这是一个回调。底层实现是基于回调机制的。
            调用处理器是什么注册的?
                在创建代理类对象的时候注册的。
            调用处理器中的代码什么时候执行?
                在代理对象执行代理方法的时候，注册在调用处理器中的invoke方法会被自动调用。
       */

        //OrderService proxy = (OrderService)Proxy.newProxyInstance(类加载器，要实现的接口,调用处理器);
        //这一步功能:注册调用处理器。
        OrderService proxy = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimerInvocationHandler(target));

        //通过调用代理对象的代理方法间接执行目标对象的目标方法。
        //执行这里的时候，注册在调用处理器中的invoke回调会被自动调用。
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }
    /*
        订单已生成
        com.wyjun.proxy.service.OrderServiceImpl's generate() running : 1236ms
        订单已修改
        com.wyjun.proxy.service.OrderServiceImpl's modify() running : 1016ms
        订单信息如下：******
        com.wyjun.proxy.service.OrderServiceImpl's detail() running : 2543ms
    */
}
