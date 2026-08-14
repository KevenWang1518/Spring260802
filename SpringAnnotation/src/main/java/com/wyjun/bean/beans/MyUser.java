package com.wyjun.bean.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // 将User纳入IoC容器的管理，它是一个Bean了。
public class MyUser {

    //@Value(value = "Zhangsan")
    //@Value注解如果直接使用在Field上，底层会直接通过反射机制中的Field完成赋值，不走set方法。
    private String name;

    //@Value("20")//简写形式，不写@Value(value="20")也可以
    private int age;

    @Value(value = "Zhangsan")
    //@Value 注解也可以出现在方法上。
    //spring会自动调用该set方法来给属性赋值。
    public void setName(String name) {
        this.name = name;
        System.out.println("setName方法执行了");
    }

    @Value(value = "20")
    //特别注意：@Value注解不能使用在静态方法上。
    //当实例方法上有@Value注解，同时对应的属性上也有@Value注解。(set方法上的@Value注解优先级较高。)
    public void setAge(int age) {
        this.age = age;
        System.out.println("setAge方法执行了");
    }


    @Override
    public String toString() {
        return "MyUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
