package com.wyjun;

import com.wyjun.bean.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCycleTest {
    @Test
    void springCycleTest1() {
        //需要使用 ClassPathXmlApplicationContext，不能使用 ApplicationContext
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println("4.使用Bean");
        System.out.println(user);

        // 这个代码执行时，就没有再调用init方法了。(init方法只执行一次。destory也只执行一次)
        User user2 = applicationContext.getBean("userBean", User.class);
        System.out.println("4.使用Bean");
        System.out.println(user2);

        //只有正常关闭spring容器才会执行销毁方法，如果不手动关闭容器，bean的destroy方法是不会执行的。
        applicationContext.close();
    }/*
        1.无参构造执行了，实例化Bean=com.wyjun.bean.entity.User@3c9bfddc
        2.Bean属性赋值执行了，给name属性赋值=ZhangSan
        3.初始化Bean执行了
        4.使用Bean
        com.wyjun.bean.entity.User@3c9bfddc
        4.使用Bean
        com.wyjun.bean.entity.User@3c9bfddc
        5.销毁Bean执行了
    */

    @Test
    void springCycleTest2() {
        //需要使用 ClassPathXmlApplicationContext，不能使用 ApplicationContext
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println("4.使用Bean");
        System.out.println(user);

        // 这个代码执行时，就没有再调用init方法了。(init方法只执行一次。destory也只执行一次)
        User user2 = applicationContext.getBean("userBean", User.class);
        System.out.println("4.使用Bean");
        System.out.println(user2);

        //只有正常关闭spring容器才会执行销毁方法，如果不手动关闭容器，bean的destroy方法是不会执行的。
        applicationContext.close();
    }/*
        1.无参构造执行了，实例化Bean=com.wyjun.bean.entity.User@63fdab07
        2.Bean属性赋值执行了，给name属性赋值=ZhangSan
        Bean后处理器的before方法执行，初始化即将开始
        3.初始化Bean执行了
        Bean后处理器的after方法执行，初始化已经完成
        4.使用Bean
        com.wyjun.bean.entity.User@63fdab07
        4.使用Bean
        com.wyjun.bean.entity.User@63fdab07
        5.销毁Bean执行了
        */

    @Test
    void springCycleTest3() {
        //需要使用 ClassPathXmlApplicationContext，不能使用 ApplicationContext
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext3.xml");
        User2 user = applicationContext.getBean("userBean", User2.class);
        System.out.println("开始使用Bean");
        System.out.println(user);

        // 这个代码执行时，就没有再调用init方法了。(init方法只执行一次。destory也只执行一次)
        User2 user2 = applicationContext.getBean("userBean", User2.class);
        System.out.println("再次使用Bean");
        System.out.println(user2);

        //只有正常关闭spring容器才会执行销毁方法，如果不手动关闭容器，bean的destroy方法是不会执行的。
        applicationContext.close();
    }/*
        1.实例化Bean
        2.Bean属性赋值
        3.bean名字：userBean
        3.类加载器：jdk.internal.loader.ClassLoaders$AppClassLoader@36baf30c
        3.Bean工厂：org.springframework.beans.factory.support.DefaultListableBeanFactory@6f152006: defining beans [userBean,com.wyjun.bean.entity.LogBeanPostProcessor#0]; root of factory hierarchy
        Bean后处理器的before方法执行，初始化即将开始
        5.afterPropertiesSet执行
        6.初始化Bean
        Bean后处理器的after方法执行，初始化已经完成
        开始使用Bean
        com.wyjun.bean.entity.User2@7b324585
        再次使用Bean
        com.wyjun.bean.entity.User2@7b324585
        9.DisposableBean destroy
        10.销毁Bean
    */

    @Test
    void springCycleTest4() {
        // 手动自己new出来的对象
        User user = new User();
        System.out.println(user);

        // 创建默认可列表BeanFactory工厂对象
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        // 注册Bean，将这个对象纳入springIOC容器管理。
        factory.registerSingleton("userBean", user);

        // 从springIOC容器中获取bean
        User userBean = factory.getBean("userBean", User.class);
        System.out.println(userBean);
    }
    /*
    1.无参构造执行了，实例化Bean=com.wyjun.bean.entity.User@1184ab05
        com.wyjun.bean.entity.User@1184ab05
        com.wyjun.bean.entity.User@1184ab05
    */
}