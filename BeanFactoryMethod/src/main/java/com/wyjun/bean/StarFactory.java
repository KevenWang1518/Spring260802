package com.wyjun.bean;

//简单工厂模式中的全能类。(上帝类)
public class StarFactory {
    public static Star getStar() {
        //底层实际上这个对象是我们自己new出来的。
        return new Star();
    }
}
