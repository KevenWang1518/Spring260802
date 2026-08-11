package com.wyjun;

import com.wyjun.bean.Order;
import com.wyjun.bean.Person;
import com.wyjun.bean.Star;
import com.wyjun.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDITest {
    @Test
    void springDITest1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Star starBean = applicationContext.getBean("starBean", Star.class);
        System.out.println(starBean);
    }//com.wyjun.bean.Star@1af146

    @Test
    void springDITest2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Order orderBean = applicationContext.getBean("orderBean", Order.class);
        System.out.println(orderBean);
    }//com.wyjun.bean.Order@72758afa

    @Test
    void springDITest3() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person personBean = applicationContext.getBean("personBean", Person.class);
        System.out.println(personBean);
    }//com.wyjun.bean.Person@a5bd950

    @Test
    void springDITest4() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }//User{birthday=Sat Sep 29 00:00:00 CST 2001}
}