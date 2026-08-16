package com.wyjun.bean.user2;

import org.springframework.stereotype.Repository;
@Repository("userDaoImpl2")
public class UserDaoImpl2 implements UserDao2 {
    @Override
    public void insert() {
        System.out.println("userDao:插入用户信息到数据库");
    }
}