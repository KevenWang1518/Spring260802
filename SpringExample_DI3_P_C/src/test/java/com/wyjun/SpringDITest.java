package com.wyjun;

import com.wyjun.bean.entity.*;
import com.wyjun.bean.service.AccountService;
import com.wyjun.bean.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDITest {
    @Test
    void springDITest1() {//利用P命名空间
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }//User{name='ZhangSan', age=20}

    @Test
    void springDITest2() {//利用C命名空间
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyDate myDate = applicationContext.getBean("myDate", MyDate.class);
        System.out.println(myDate);
    }//MyDate{year=2026, month=8, day=10}

    @Test
    void springDITest3() {//利用util命名空间
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyDataSource1 dataSource1 = applicationContext.getBean("dataSource1", MyDataSource1.class);
        System.out.println(dataSource1);
        MyDataSource2 dataSource2 = applicationContext.getBean("dataSource2", MyDataSource2.class);
        System.out.println(dataSource2);
    }//MyDataSource1{properties={password=123456, driver=com.mysql.cj.jdbc.Driver, url=jdbc:mysql://localhost:3306/wyjun, username=root}}
    //MyDataSource2{properties={password=123456, driver=com.mysql.cj.jdbc.Driver, url=jdbc:mysql://localhost:3306/wyjun, username=root}}

    @Test
    void springDITest4() {//利用byName自动装配
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        System.out.println(accountService);
        accountService.save();
    }//AccountService{accountDao=com.wyjun.bean.dao.AccountDao@6f603e89}
    //保存用户信息...

    @Test
    void springDITest5() {//利用byType自动装配
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = applicationContext.getBean("productService", ProductService.class);
        System.out.println(productService);
        productService.save();
    }//ProductService{productDao=com.wyjun.bean.dao.ProductDao@5ef0d29e}
    //保存商品信息...

    @Test
    void springDITest6() {//利用context自动装配
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyDataSource dataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(dataSource);
    }//MyDataSource{driver='com.mysql.cj.jdbc.Driver', url='jdbc:mysql://localhost:3306/wyjun', username='root', password='123456'}

    @Test
    void springDITest7() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(applicationContext.getBean("springBean1", SpringBean.class));
        System.out.println(applicationContext.getBean("springBean1", SpringBean.class));
        System.out.println(applicationContext.getBean("springBean1", SpringBean.class));

        System.out.println(applicationContext.getBean("springBean2", SpringBean.class));
        System.out.println(applicationContext.getBean("springBean2", SpringBean.class));
        System.out.println(applicationContext.getBean("springBean2", SpringBean.class));
    }//com.wyjun.bean.entity.SpringBean@28276e50
     //com.wyjun.bean.entity.SpringBean@28276e50
     //com.wyjun.bean.entity.SpringBean@28276e50

     //com.wyjun.bean.entity.SpringBean@62e70ea3
     //com.wyjun.bean.entity.SpringBean@3efe7086
     //com.wyjun.bean.entity.SpringBean@675d8c96
}