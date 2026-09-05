package com.wyjun.aop;

import com.wyjun.config.SpringConfig;
import com.wyjun.entity.Husband;
import com.wyjun.entity.Wife;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMybatisTest {

    @Test
    public void SpringMybatisTest1() {//分别用p空间和c空间获取循环依赖bean对象
        System.out.println("第一种方式========================================================");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Husband husband1 = context.getBean("husbandBean1", Husband.class);
        Wife wife1 = context.getBean("wifeBean1", Wife.class);

        husband1.setName("ZhangSan");
        wife1.setName("Lucy");

        husband1.setWife(wife1);
        wife1.setHusband(husband1);

        System.out.println(husband1);
        System.out.println(wife1);

        System.out.println("第二种方式========================================================");

        Husband husband2 = context.getBean("husbandBean2", Husband.class);
        Wife wife2 = context.getBean("wifeBean2", Wife.class);

        husband2.setName("ZhangSan");
        wife2.setName("Lucy");

        husband2.setWife(wife2);
        wife2.setHusband(husband2);

        System.out.println(husband2);
        System.out.println(wife2);

        System.out.println("第三种方式========================================================");

        Husband husband3 = context.getBean("husbandBean3", Husband.class);
        Wife wife3 = context.getBean("wifeBean3", Wife.class);

        husband3.setName("ZhangSan");
        wife3.setName("Lucy");

        husband2.setWife(wife3);
        wife2.setHusband(husband3);

        System.out.println(husband3);
        System.out.println(wife3);
    }
    //第一种方式========================================================
    //Husband{name='ZhangSan', wife=Lucy}
    //Wife{name='Lucy', husband=ZhangSan}
    //第二种方式========================================================
    //Husband{name='ZhangSan', wife=Lucy}
    //Wife{name='Lucy', husband=ZhangSan}
    //第三种方式========================================================
    //Husband{name='ZhangSan', wife=Lucy}
    //Wife{name='Lucy', husband=ZhangSan}

    @Test
    public void SpringMybatisTest2() { //这里使用的是SpringConfig全注解配置类，不用再写spring.xml文件，注意获取context方法不同，效果相同。
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Husband husband = context.getBean("husband", Husband.class);
        Wife wife = context.getBean("wife", Wife.class);

        husband.setName("ZhangSan");
        wife.setName("Lucy");

        husband.setWife(wife);
        wife.setHusband(husband);

        System.out.println(husband);
        System.out.println(wife);

    }
    //Husband{name='ZhangSan', wife=Lucy}
    //Wife{name='Lucy', husband=ZhangSan}

}
