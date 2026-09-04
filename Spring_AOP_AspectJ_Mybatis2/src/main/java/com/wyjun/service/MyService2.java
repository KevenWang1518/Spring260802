package com.wyjun.service;

import com.wyjun.entity.Account;
import com.wyjun.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MyService2 {

    @Autowired
    private AccountMapper accountMapper;

    //Propagation.REQUIRED表示，没有事务的时候开启一个新的事务，有事务的话，就加入到当前事务。
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account account) {
        accountMapper.insertAccount(account);

        //模拟异常
        System.out.println(10 / 0);
    }
}
