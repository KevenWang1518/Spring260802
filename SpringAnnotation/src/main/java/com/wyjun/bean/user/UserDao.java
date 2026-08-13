package com.wyjun.bean.user;

import org.springframework.stereotype.Repository;

//@Repository(value = "userDao")
@Repository
//当没有指定bean的名字的时候，会默认将类的简类名作为bean的名字。
//当这个注解标注之后(即单纯写个@Repository，没有跟value="xxx")，那么这个bean的默认名字叫:userDao
public class UserDao {
    public void insert() {
        System.out.println("保存用户信息");
    }
}
