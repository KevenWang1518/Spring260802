package com.wyjun.bean;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

//协助Spring去实例化其他的bean。
public class DateFactoryBean implements FactoryBean<Date> {

    //注入一个日期字符串
    private String stringDate;

    //通过构造方法来完成日期字符串的注入。
    public DateFactoryBean(String stringDate) {
        this.stringDate = stringDate;
    }

    //格式化后返回Date对象
    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMdd");
        return sdf.parse(stringDate);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
