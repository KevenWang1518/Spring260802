package com.wyjun.bean.controller;

import com.wyjun.bean.service.UserService;
import com.wyjun.bean.service.UserServiceImpl;

public class UserController {

    //不再用以前的这种形式，违背OCP和DIP。
    //private UserService userService = new UserServiceImpl();

    private UserService userService;

    //为userService提供一个setter方法，否则为null报错。
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser() {
        System.out.println("UserController saveUser method begin");

        //三层架构 controller调用service
        userService.save();

        System.out.println("UserController saveUser method end");
    }
}
