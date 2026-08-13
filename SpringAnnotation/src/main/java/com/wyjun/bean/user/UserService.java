package com.wyjun.bean.user;

import org.springframework.stereotype.Service;

//@Service(value = "userService")
@Service
//当没有指定bean的名字的时候，会默认将类的简类名作为bean的名字。
//当这个注解标注之后(即单纯写个@Service，没有跟value="xxx")，那么这个bean的默认名字叫:userService
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.insert();
    }
}
