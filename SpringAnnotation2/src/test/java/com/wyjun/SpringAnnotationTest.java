package com.wyjun;

import com.wyjun.bean.user.UserController;
import com.wyjun.bean.user.UserDao;
import com.wyjun.bean.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationTest {
    @Test
    void springAnnotationTest1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDaoBean = applicationContext.getBean("userDao", UserDao.class);
        UserService userServiceBean = applicationContext.getBean("userService", UserService.class);
        UserController userControllerBean = applicationContext.getBean("userController", UserController.class);

        System.out.println(userDaoBean);
        System.out.println(userServiceBean);
        System.out.println(userControllerBean);
    }/*
        com.wyjun.bean.user.UserDao@5f2606b
        com.wyjun.bean.user.UserService@2b58f754
        com.wyjun.bean.user.UserController@3ebff828
    */

    @Test
    void springAnnotationTest2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserController userControllerBean = applicationContext.getBean("userController", UserController.class);
        userControllerBean.saveUser();
    }//保存用户信息

    @Test
    void springAnnotationTest3() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserController userControllerBean = applicationContext.getBean("userController", UserController.class);
        userControllerBean.saveUser();
    }//保存用户信息到MySQL数据库

}
