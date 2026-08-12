package com.wyjun.bean.entity;

public class User {
    private String name;

    public User() {
        System.out.println("1.无参构造执行了，实例化Bean=" + this);
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2.Bean属性赋值执行了，给name属性赋值=" + name);
    }

    public void initBean() {
        System.out.println("3.初始化Bean执行了");
    }

    public void destroyBean() {
        System.out.println("5.销毁Bean执行了");
    }
}
