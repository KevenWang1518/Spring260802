package com.wyjun.bean.user;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplForOracle implements UserDao {
    @Override
    public void insert() {
        System.out.println("保存用户信息到Oracle数据库");
    }
}