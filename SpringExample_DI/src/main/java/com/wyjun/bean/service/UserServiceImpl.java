package com.wyjun.bean.service;

import com.wyjun.bean.dao.UserDao;
import com.wyjun.bean.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

    //不再用以前的这种形式，违背OCP和DIP。
    //private UserDao userDao = new UserDaoImpl();

    private UserDao userDao;

    //为userDao提供一个setter方法，否则为null报错。
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("UserService save method begin");

        //三层架构 service调用dao
        userDao.insert();

        System.out.println("UserService save method end");
    }
}
