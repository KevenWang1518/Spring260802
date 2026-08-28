package com.wyjun.Proxy;

import com.wyjun.proxy.service.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class CglibProxyTest {
    @Test
    public void cglibProxyTest1() {
        //目标对象
        UserService target = new UserService();

        // 创建字节码增强器
        Enhancer enhancer = new Enhancer();

        // 告诉cglib要继承(要代理)哪个类  (告诉它父类是谁，因为CGLIB底层使用的是继承机制。)
        enhancer.setSuperclass(UserService.class);

        // 告诉cglib要代理哪个接口（如果要使用cglib进行接口的代理，这样写。）
        //enhancer.setInterfaces(UserServiceImpl.class.getInterfaces());

        // 设置回调接口
        enhancer.setCallback(new MethodInterceptor() {
            /*
            关于cglib回调函数中的4个参数:
            Object o:代理对象。(不是目标对象)
            Method method:目标方法
            Object[] objects:目标方法上的参数
            MethodProxy methodProxy:
                是cglib对目标方法method进行增强的一个对象。(通过它调用目标对象的目标方法效率较高。
                methodProxy调用的时候是不会经过原始反射机制的，是字节码直接调用。
                methodProxy是cgLib框架底层经过优化之后的一个对象，比我们原始的通过原生反射机制调用 method.invoke() 效率高一些。
            */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //第一种情况:通过原生的反射机制调用。前后功能增强。
                //System.out.println(target.getClass().getName() + "." + method.getName() + "()... begin");
                //Object retValue = method.invoke(target, objects);//注意这里调用的是target目标对象
                //System.out.println(target.getClass().getName() + "." + method.getName() + "()... end");

                //第二种情况:通过CGLIB优化之后的methodProxy来调用。(CGLIB优化之后的，效率较高，官方建议使用这种方式)
                System.out.println(target.getClass().getName() + "." + method.getName() + "()... begin");
                Object retValue = methodProxy.invokeSuper(o, objects);//注意这里调用的是o代理对象
                System.out.println(target.getClass().getName() + "." + method.getName() + "()... end");
                return retValue;
            }
        });

        // 创建代理对象
        // 生成源码，编译class，加载到JVM，并创建代理对象
        UserService userServiceProxy = (UserService) enhancer.create();

        //调用代理对象的代理方法。(这样底层会自动调用目标对象的目标方法:通过回调来实现的。)
        userServiceProxy.login();
        userServiceProxy.logout();
    }
    /*
        com.wyjun.proxy.service.UserService.login()... begin
        用户正在登录系统....
        com.wyjun.proxy.service.UserService.login()... end
        com.wyjun.proxy.service.UserService.logout()... begin
        用户正在退出系统....
        com.wyjun.proxy.service.UserService.logout()... end
    */
}