package com.wyjun.bean.service;

import com.wyjun.bean.dao.AccountDao;

public class AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void save() {
        accountDao.insert();
    }

    @Override
    public String toString() {
        return "AccountService{" +
                "accountDao=" + accountDao +
                '}';
    }
}
