package com.wyjun.bean.user2;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

//一句话总结@Resource注解：默认byName注入，没有指定name时把属性名当做name，根据name找不到时，才会byType注入。byType注入时，某种类型的Bean只能有一个。
@Service
public class UserService2 {

    //@Resource
    //不写这个@Resource的话，会报错：
    //java.lang.NullPointerException: Cannot invoke "com.wyjun.bean.user2.UserDao2.insert()" because "this.userDao2" is null
    //@Resource注解默认根据名称装配byName，未指定name时，使用属性名作为name。通过name找不到的话会自动启动通过类型byType装配。
    //@Autowired注解默认根据类型装配byType，如果想根据名称装配，需要配合@Qualifier注解一起用。
    //@Resource（name = "userDao2") 注意这里写的话是name属性，不是value属性。
    private UserDao2 userDao2;

    @Resource(name = "userDaoImpl2")
    //@Resource注解可以用在属性上、setter方法上。
    //@Autowired注解可以用在属性上、setter方法上、构造方法上、构造方法参数上。
    public void setUserDao2(UserDao2 userDao2) {
        this.userDao2 = userDao2;
    }

    public void saveUser() {
        System.out.println("userService:保存用户信息中");
        userDao2.insert();
    }
}
