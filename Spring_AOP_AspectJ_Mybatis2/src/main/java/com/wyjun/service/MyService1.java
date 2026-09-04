package com.wyjun.service;

import com.wyjun.entity.Account;
import com.wyjun.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class MyService1 {
    //模拟在一个事务中调用另外一个事务

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private MyService2 myService2;

    @Autowired
    private MyService3 myService3;

    //Propagation.REQUIRED表示，没有事务的时候开启一个新的事务，有事务的话，就加入到当前事务。
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account account) {

        accountMapper.insertAccount(account);

        try {
            Account account_embedded2 = new Account();
            account_embedded2.setActNo("act_005");
            account_embedded2.setBalance(new BigDecimal(25000));
            myService2.save(account_embedded2);
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }

        try {
            Account account_embedded3 = new Account();
            account_embedded3.setActNo("act_006");
            account_embedded3.setBalance(new BigDecimal(15000));
            myService3.save(account_embedded3);
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }
}
