package com.wyjun.proxy.service;

// 这是一个类，不是接口了。CGLIB没有接口的时候也可以代理类。
public class UserService {
    public void login() {
        System.out.println("用户正在登录系统....");
    }

    public void logout() {
        System.out.println("用户正在退出系统....");
    }
}
