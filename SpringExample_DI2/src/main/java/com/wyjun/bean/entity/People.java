package com.wyjun.bean.entity;

import java.util.Properties;
import java.util.Set;
import java.util.Map;

public class People {
    //一个人有多个手机号
    private Set<String> phones;

    //一个人有多个地址
    private Map<Integer, String> addresses;

    //一人个有多个其它属性
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setAddresses(Map<Integer, String> addresses) {
        this.addresses = addresses;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public People() {
    }

    @Override
    public String toString() {
        return "People{" +
                "phones=" + phones +
                ", addresses=" + addresses +
                ", properties=" + properties +
                '}';
    }
}
