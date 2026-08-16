package com.wyjun;

import com.wyjun.bean.user.SpringConfiguration;
import com.wyjun.bean.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class SpringTest {
    @Test
    void springTest() {
        //获取上下文对象的方式变化了，不再使用XML文件了。
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.save();

        //Date getDate = context.getBean("getDate", Date.class);//@Bean不写名字，默认用方法名，也可以。
        Date nowDate = context.getBean("myNowDate", Date.class); //@Bean写了名字，就直接用名字。
        System.out.println(nowDate);

    }//保存用户信息...
     //Sun Aug 16 21:36:14 CST 2026
}
