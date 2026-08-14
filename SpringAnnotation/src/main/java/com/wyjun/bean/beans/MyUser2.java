package com.wyjun.bean.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // 将User纳入IoC容器的管理，它是一个Bean了。
public class MyUser2 {

    private String name;

    private int age;

    //@value可以写在属性上，方法上，构造方法的参数上
    //但是不能直接写在构造方法上
    public MyUser2(@Value("Lisi") String name, @Value("30") int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName方法执行了");
    }

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
