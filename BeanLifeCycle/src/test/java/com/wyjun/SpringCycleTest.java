package com.wyjun;

import com.wyjun.bean.entity.*;
import org.junit.jupiter.api.Test;
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

}