package com.wyjun;

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
        UserController userController= applicationContext.getBean("userControllerBean", UserController.class);
        userController.saveUser();
    }
    //UserController saveUser method begin
    //UserService save method begin
    //插入用户信息ing...
    //UserService save method end
    //UserController saveUser method end
}
