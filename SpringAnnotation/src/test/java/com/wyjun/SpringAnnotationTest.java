package com.wyjun;

import com.wyjun.bean.beans.MyUser;
import com.wyjun.bean.beans.MyUser2;
import com.wyjun.bean.order.OrderController;
import com.wyjun.bean.user.UserController;
import com.wyjun.bean.user.UserDao;
import com.wyjun.bean.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationTest {
    @Test
    void springAnnotationTest0() {
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
    void springAnnotationTest1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserController userControllerBean = applicationContext.getBean("userController", UserController.class);
        userControllerBean.saveUser();
    }//保存用户信息

    @Test
    void springAnnotationTest2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        OrderController orderController = applicationContext.getBean("orderController", OrderController.class);
        System.out.println(orderController);
    }//com.wyjun.bean.order.OrderController@2552f2cb

    @Test
    void springAnnotationTest3() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
    }/*
        B的无参数构造方法执行
        E的无参数构造方法执行
        F的无参数构造方法执行
    */

    @Test
    void springAnnotationTest4() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext3.xml");
    }//A的无参数构造方法执行

    @Test
    void springAnnotationTest5() {//属性和方法上使用@value赋值
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        MyUser myUser = applicationContext.getBean("myUser", MyUser.class);
        System.out.println(myUser);
    }/*
        setName方法执行了
        setAge方法执行了
        MyUser{name='Zhangsan', age=20}
    */

    @Test
    void springAnnotationTest6() {//构造方法上直接使用@value赋值
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        MyUser2 myUser2 = applicationContext.getBean("myUser2", MyUser2.class);
        System.out.println(myUser2);
    }/*
        setName方法执行了
        setAge方法执行了
        MyUser{name='Lisi', age=30}
    */
}
