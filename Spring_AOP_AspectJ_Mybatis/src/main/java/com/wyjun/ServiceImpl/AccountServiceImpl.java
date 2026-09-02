package com.wyjun.ServiceImpl;

import com.wyjun.entity.Account;
import com.wyjun.mapper.AccountMapper;
import com.wyjun.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired //根据类型进行装配，也可以搭配@Qualifier根据名称进行装配。
    private AccountMapper accountMapper;

    @Override
    @Transactional //这个方法必须保证事务。
    public void transfer(String fromActNo, String toActNo, BigDecimal amount) {

        //查询转出账户信息
        Account account = accountMapper.selectByActNo(fromActNo);

    }
}
