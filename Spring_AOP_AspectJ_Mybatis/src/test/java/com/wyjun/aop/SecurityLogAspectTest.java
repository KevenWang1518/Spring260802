package com.wyjun.aop;

import com.wyjun.config.SpringConfig;
import com.wyjun.service.ProductService;
import com.wyjun.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SecurityLogAspectTest {
    @Test
    public void securityLogAspectTest1() { //这里使用的是SpringConfig全注解配置类，不用再写spring.xml文件，注意获取context方法不同，效果相同。
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        //根据名字获取UserService的bean
        UserService userService = context.getBean("userServiceImpl", UserService.class);
        userService.getUser();//get未加入切面，没有操作日志
        userService.modifyUser();
        userService.saveUser();
        userService.deleteUser();

        //根据类型获取ProductService的bean
        ProductService productService = context.getBean(ProductService.class);
        productService.getProduct();//get未加入切面，没有操作日志
        productService.modifyProduct();
        productService.saveProduct();
        productService.deleteProduct();
    }
}
    /*
        获取用户信息......
        修改用户......
        2026-08-30 11:45:01:172 操作员执行了com.wyjun.ServiceImpl.UserServiceImpl`s modifyUser()
        保存用户......
        2026-08-30 11:45:01:176 操作员执行了com.wyjun.ServiceImpl.UserServiceImpl`s saveUser()
        删除用户......
        2026-08-30 11:45:01:177 操作员执行了com.wyjun.ServiceImpl.UserServiceImpl`s deleteUser()
        获取商品信息......
        修改商品......
        2026-08-30 11:45:01:178 操作员执行了com.wyjun.ServiceImpl.ProductServiceImpl`s modifyProduct()
        保存商品......
        2026-08-30 11:45:01:178 操作员执行了com.wyjun.ServiceImpl.ProductServiceImpl`s saveProduct()
        删除商品......
        2026-08-30 11:45:01:179 操作员执行了com.wyjun.ServiceImpl.ProductServiceImpl`s deleteProduct()
     */
