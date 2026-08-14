package com.wyjun.bean.user;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplForMySQL implements UserDao {
    @Override
    public void insert() {
        System.out.println("保存用户信息到MySQL数据库");
    }
}