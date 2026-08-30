package com.wyjun.aop;

import com.wyjun.config.SpringConfig;
import com.wyjun.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {
    @Test //第一种测试方式
    public void aspectTest1() { //这里使用的还是spring.xml文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.generate();
    }
    /*
        环绕通知开始
        这是一个前置通知
        业务订单己生成......
        这是一个返回通知
        这是一个后置通知
        环绕通知结束
    */

    @Test //第二种测试方式
    public void aspectTest2() { //这里使用的是SpringConfig全注解配置类，不用再写spring.xml文件，注意获取context方法不同，效果相同。
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        //根据名字获取bean
        OrderService orderService = context.getBean("orderService", OrderService.class);

        //根据类型获取bean，以下代码可以正常执行
        //OrderService orderService = context.getBean(OrderService.class);

        orderService.generate();
        System.out.println("订单数量=" + orderService.getOrderNumber());
    }
    /*
        MyAspect1环绕通知开始
        random Number is 9
        这是一个MyAspect1前置通知
        MyAspect2环绕通知开始
        random Number is 4
        MyAspect2目标对象的目标方法未执行!!!
        MyAspect2环绕通知结束
        这是一个MyAspect1返回通知
        这是一个MyAspect1后置通知
        MyAspect1环绕通知结束
        MyAspect1环绕通知开始
        random Number is 6
        这是一个MyAspect1前置通知
        MyAspect2环绕通知开始
        random Number is 2
        MyAspect2目标对象的目标方法未执行!!!
        MyAspect2环绕通知结束
        这是一个MyAspect1返回通知
        这是一个MyAspect1后置通知
        MyAspect1环绕通知结束
        订单数量=null
    */
}
