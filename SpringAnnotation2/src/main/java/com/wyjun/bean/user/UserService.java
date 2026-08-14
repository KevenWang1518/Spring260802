package com.wyjun.bean.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Service(value = "userService")
@Service

public class UserService {

    @Autowired
    //@Qualifier("userDaoImplForMySQL") //注意默认的简类名首字母是小写
    @Qualifier("userDaoImplForOracle") //注意默认的简类名首字母是小写
    //@Autowired 注解默认会按照类型自动装配。UserDao接口下如果有多个实例都是spring bean的话，无法注入。
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.insert();
    }
}
