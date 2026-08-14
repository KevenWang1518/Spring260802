package com.wyjun.bean.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Controller(value = "userController")
@Controller
//当没有指定bean的名字的时候，会默认将类的简类名作为bean的名字。
//当这个注解标注之后(即单纯写个@Controller，没有跟value="xxx")，那么这个bean的默认名字叫:userController
public class UserController {
    //autoWired 根据类型自动装配

    @Autowired //自动装配可以放在属性上
    private UserService userService;

    //@Autowired //自动装配可以放在set方法上
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //@Autowired //自动装配可以放在构造方法上
    /*public UserController(UserService userService) {
        this.userService = userService;
    }*/

    //自动装配可以放在构造方法的参数上
    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    //如果一个Bean中仅有一个有参构造方法，这个构造方法上是带有指定参数的，那么@Autowired 注解可以省略。
    //如果还写了一个无参构造方法，那么是不行的。spring不知道选哪个。
    public void saveUser() {
        userService.save();
    }
}
