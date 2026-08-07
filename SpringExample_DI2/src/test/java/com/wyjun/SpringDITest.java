package com.wyjun;

import com.wyjun.bean.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDITest {
    @Test
    void springDITest1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }
}//User{age=20}
