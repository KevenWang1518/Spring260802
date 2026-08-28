package com.wyjun.Proxy;

import com.wyjun.proxy.service.ProductService;
import com.wyjun.proxy.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest2_Anonymous {
    @Test
    public void dynamicProxyTest() {
        //创建一个目标对象
        ProductService target = new ProductServiceImpl();

        //创建一个代理对象（其中InvocationHandler直接匿名内部类实现）
        ProductService proxy = (ProductService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
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
                System.out.println(className + "'s " + methodName + "() running : " + (endTime - startTime) + "ms");

                return retValue;
            }
        });

        //通过调用代理对象的代理方法间接执行目标对象的目标方法。
        //执行这里的时候，注册在调用处理器中的invoke回调会被自动调用。
        System.out.println(proxy.getProduct());
        proxy.removeById();

    }
    /*
        正在读取商品信息......
        com.wyjun.proxy.service.ProductServiceImpl's getProduct() running : 3015ms
        iPhone Pro Max Ultra
        正在删除商品信息......
        com.wyjun.proxy.service.ProductServiceImpl's removeById() running : 2008ms
     */
}
