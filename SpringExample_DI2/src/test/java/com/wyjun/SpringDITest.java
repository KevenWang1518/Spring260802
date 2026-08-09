package com.wyjun;

import com.wyjun.bean.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDITest {
    @Test
    void springDITest1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);
    }//User{age=20}

    @Test
    void springDITest2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyPool myPool = applicationContext.getBean("myPool", MyPool.class);
        System.out.println(myPool);
    }//MyPool{driverClassName='com.mysql.cj.jdbc.Driver', url='jdbc:mysql://localhost:3306/spring', username='root', password='123456', initialSize=10, maxActive=20}

    @Test
    void springDITest3() {//级联属性注入
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = applicationContext.getBean("student1", Student.class);
        System.out.println(student);
    }//Student{name='张三', clazz=Clazz{name='高三一班'}}

    @Test
    void springDITest4() {//级联属性注入
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = applicationContext.getBean("student2", Student.class);
        System.out.println(student);
    }//Student{name='李四', clazz=Clazz{name='高三二班'}}

    @Test
    void springDITest5() {//数组注入
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }//Person{hobbies=[运动, 旅游, 聊天]}

    @Test
    void springDITest6() {//数组注入
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Order order = applicationContext.getBean("order", Order.class);
        System.out.println(order);
    }//Order{goodsArray=[Goods{name='苹果'}, Goods{name='香蕉'}, Goods{name='桔子'}]}

    @Test
    void springDITest7() {//List注入
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer = applicationContext.getBean("customer", Customer.class);
        System.out.println(customer);
    }//Customer{names=[张三, 张三哥, 三哥]}

    @Test
    void springDITest8() {//Set注入---Map注入---Properties注入
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = applicationContext.getBean("people", People.class);
        System.out.println(people);
    }//People{phones=[13333333333, 13999999999, 136666666666], addresses={1=平安路123号, 2=健康路567号, 3=人民路678号, 4=中华路789号}, properties={work=enginer, sex=man, married=true}}

    @Test
    void springDITest9() {//空字符串注入和null注入
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Vip vip = applicationContext.getBean("vip", Vip.class);
        System.out.println(vip);
    }//Vip{name='', email='null'}
}