package com.wyjun.Proxy;

import com.wyjun.proxy.service4.OrderServiceProxy4;
import com.wyjun.proxy.service4.SpringConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProxyTest4 {
    @Test
    public void proxyTest() {

        //获取上下文对象的方式变化了，不再使用XML文件了。
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        OrderServiceProxy4 orderServiceProxy4 = context.getBean("orderServiceProxy4", OrderServiceProxy4.class);
        orderServiceProxy4.generate();
        orderServiceProxy4.detail();
        orderServiceProxy4.modify();
    }
    /*
        订单已生成
        generate()操作耗时 = 1237
        订单信息如下：******
        detail()操作耗时 = 2541
        订单已修改
        modify()操作耗时 = 1019
    */
}
