package com.wyjun.service;

import com.wyjun.entity.Account;
import com.wyjun.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IsolationService1 {

    @Autowired
    private AccountMapper accountMapper;

    //隔离级别设置为:读提交。对方事务真实提交后才能读取到。
    //@Transactional(isolation = Isolation.READ_COMMITTED)

    //隔离级别设置为:读未提交。能够读取到别的事务没有提交的数据。
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Account getAccountByActNo(String actNo) {
        return accountMapper.selectAccountByActNo(actNo);
    }
}
