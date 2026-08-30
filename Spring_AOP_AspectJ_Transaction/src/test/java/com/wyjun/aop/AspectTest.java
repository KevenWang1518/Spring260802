package com.wyjun.aop;

import com.wyjun.config.SpringConfig;
import com.wyjun.service.OrderService;
import com.wyjun.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectTest {
    @Test
    public void aspectTest1() { //这里使用的是SpringConfig全注解配置类，不用再写spring.xml文件，注意获取context方法不同，效果相同。
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        //根据名字获取UserService的bean
        UserService userService = context.getBean("userServiceImpl", UserService.class);
        userService.saveUser();//保存方法己加入切面，己增加事务。
        userService.searchUser();//查询方法没有加入切面，不会增加事务。

        //根据类型获取OrderService的bean
        OrderService orderService = context.getBean(OrderService.class);
        orderService.saveOrder();//保存方法己加入切面，己增加事务。
        orderService.searchOrder();//查询方法没有加入切面，不会增加事务。
    }
    /*
        开启事务
        正在保存用户信息......
        提交事务
        正在查询用户信息......
        开启事务
        正在生成订单信息......
        提交事务
        正在查询订单信息......
     */
}
