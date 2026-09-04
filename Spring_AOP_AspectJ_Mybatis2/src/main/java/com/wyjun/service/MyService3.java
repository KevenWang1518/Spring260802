package com.wyjun.service;

import com.wyjun.entity.Account;
import com.wyjun.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService3 {

    @Autowired
    private AccountMapper accountMapper;

    //Propagation.REQUIRED_NEW表示，一定会开启一个新的事务，开启的新事务与当前事务的关系是:平行事务。(不是包含关系。)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Account account) {
        accountMapper.insertAccount(account);

        //模拟异常
        System.out.println(10 / 0);
    }
}
