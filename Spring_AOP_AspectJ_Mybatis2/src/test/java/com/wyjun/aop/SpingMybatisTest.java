package com.wyjun.aop;

import com.wyjun.config.SpringConfig;
import com.wyjun.entity.Account;
import com.wyjun.service.IsolationService1;
import com.wyjun.service.IsolationService2;
import com.wyjun.service.MyService1;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class SpingMybatisTest {
    @Test
    public void SpingMybatisTest1() { //这里使用的是SpringConfig全注解配置类，不用再写spring.xml文件，注意获取context方法不同，效果相同。
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        MyService1 myService1 = context.getBean(MyService1.class);

        Account account = new Account();
        account.setActNo("act_007");
        account.setBalance(new BigDecimal(35000));
        myService1.save(account);
    }
    //org.springframework.transaction.UnexpectedRollbackException: Transaction rolled back because it has been marked as rollback-only
    //对于Propagation.REQUIRES，事务回滚了，2条插入记录都回滚了，因为它们是同一个事务。
    //对于Propagation.REQUIRES_NEW，1个事务成功了，另1个事务回滚了，1条插入成功，1条插入失败，因为他们是2个不同的事务。

    @Test
    public void SpingMybatisTest2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        IsolationService1 isolationService1 = context.getBean(IsolationService1.class);
        Account account = isolationService1.getAccountByActNo("act_007");
        System.out.println(account.toString());
    }

    @Test
    public void SpingMybatisTest3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        IsolationService2 isolationService2 = context.getBean(IsolationService2.class);

        Account account = new Account();
        account.setActNo("act_007");
        account.setBalance(new BigDecimal(70000));
        isolationService2.saveAccount(account);
    }
    //注意这里隔离级别设置为:读未提交。就算还没有提交，还没有实际写入数据库，但已经可以读取到信息了。
    //Account(id=27, actNo=act_007, balance=70000.00)
}
