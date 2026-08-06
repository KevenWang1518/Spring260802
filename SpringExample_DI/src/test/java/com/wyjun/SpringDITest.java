package com.wyjun;

import com.wyjun.bean.controller.OrderController;
import com.wyjun.bean.controller.OrderController2;
import com.wyjun.bean.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDITest {
    @Test
    void springDITest1() {
        //UserController userController = new UserController();
        //userController.saveUser();
        //报错：java.lang.NullPointerException: Cannot invoke "com.wyjun.bean.service.UserService.save()" because "this.userService" is null

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = applicationContext.getBean("userControllerBean", UserController.class);
        userController.saveUser();
    }
    //UserController saveUser method begin
    //UserService save method begin
    //插入用户信息1...
    //UserService save method end
    //UserController saveUser method end

    @Test
    void springDITest2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserController userController = applicationContext.getBean("userControllerBean", UserController.class);
        userController.saveUser();
    }
    //注意这里只修改了applicationContext2.xml，只修改了配置文件，程序本身不用动。
    //UserController saveUser method begin
    //UserService save method begin
    //插入用户信息2...
    //UserService save method end
    //UserController saveUser method end

    @Test
    void springDITest3() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext3.xml");
        OrderController orderController = applicationContext.getBean("orderControllerBean", OrderController.class);
        orderController.save();
    }
    //Controller save order begin
    //订单开始保存
    //保存订单...
    //订单保存成功
    //Controller save order end

    @Test
    void springDITest4() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext4.xml");
        OrderController2 orderController2 = applicationContext.getBean("orderControllerBean", OrderController2.class);
        orderController2.save();
    }
    //Controller save order begin
    //订单开始保存
    //保存订单...
    //订单保存成功
    //UserService save method begin
    //插入用户信息1...
    //UserService save method end
    //Controller save order end
}
