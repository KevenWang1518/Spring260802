package com.wyjun.bean.user;

import org.springframework.stereotype.Controller;

//@Controller(value = "userController")
@Controller
//当没有指定bean的名字的时候，会默认将类的简类名作为bean的名字。
//当这个注解标注之后(即单纯写个@Controller，没有跟value="xxx")，那么这个bean的默认名字叫:userController
public class UserController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser() {
        userService.save();
    }
}
