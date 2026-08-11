package com.wyjun.bean;

//具体工厂。(这个系统中没有定义抽象工厂)
//把这个类叫做 FactoryBean，作用是协助Spring框架完成bean的实例化。-->
public class OrderFactory {
    public Order getOrder() {
        //对象的创建还是程序员自己创建的。但是该对象的生命周期会纳入IoC容器的管理。
        //因此它是一个Spring Bean。
        return new Order();
    }
}
