package com.wyjun.bean;

import org.springframework.beans.factory.FactoryBean;

    //这不是一个普通的类了。因为实现了特定的接口。
    //这个类被我们称为:FactoryBean
    //FactoryBean 本身是一个Bean，本身已经纳入IoC容器的管理了。
    //FactoryBean 的作用是:协助Spring框架完成bean的实例化。
    //BeanFactory是Spring框架的顶级接口。不是一个Bean。本身是一个工厂，这个工厂负责实例化bean。
public class PersonFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        //返回单例对象。
        return true;
    }
}
