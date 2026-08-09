package com.wyjun.bean.entity;

//级联属性赋值
public class Clazz {
    private String name;

    public Clazz() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "name='" + name + '\'' +
                '}';
    }
}
