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
