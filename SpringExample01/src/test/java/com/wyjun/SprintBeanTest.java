package com.wyjun;

import com.wyjun.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;

public class SprintBeanTest {
    @Test
    void testFirstSpringBean() {
        // 获取Spring容器的应用上下文对象(获取整个IoC容器)
        // 以下代码表示从类路径当中加载 beans.xml 文件。使用这种方式，spring配置文件必须放在类路径下。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        //从spring的IoC容器当中获取一个id="userBean" 的bean对象。注意参数是一个字符串
        Object userBean1 = applicationContext.getBean("userBean");
        System.out.println(userBean1);

        //通过测试得知，默认情况下再次获取bean的时候，不会创建新的bean对象(默认Bean是单例的。
        Object userBean2 = applicationContext.getBean("userBean");
        System.out.println(userBean2);
    }
    //com.wyjun.bean.User@7f2cfe3f
    //com.wyjun.bean.User@7f2cfe3f

    @Test
    void testManySpringBean() {
        //支持多个spring配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml", "beans2.xml");

        System.out.println(applicationContext.getBean("userBean"));
        System.out.println(applicationContext.getBean("companyBean"));
        System.out.println(applicationContext.getBean("nowTime"));
    }
    //com.wyjun.bean.User@7d9f158f
    //com.wyjun.bean.Company@45efd90f
    //Tue Aug 04 13:45:14 CST 2026

    @Test
    void testSpringBean2() {
        //不再转为Object，直接转为指定类型
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);

        Date date = applicationContext.getBean("nowTime", Date.class);
        System.out.println(date);
    }
    //com.wyjun.bean.User@1a5b6f42
    //Tue Aug 04 13:54:44 CST 2026

    @Test
    void testSpringBean3() {
        //没有在根路径中的话，也可以使用其它文件路径，但这种方式较少使用，不便于移植。
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("d:/beans.xml");
        System.out.println(applicationContext.getBean("userBean"));
    }

    @Test
    void testSpringBean4() {
        System.out.println("测试Git版本控制");
    }
}
