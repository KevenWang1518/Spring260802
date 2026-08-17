package com.wyjun.Proxy;

import com.wyjun.proxy.service2.OrderService2;
import com.wyjun.proxy.service2.OrderServiceImplSub2;
import org.junit.jupiter.api.Test;

public class ProxyTest2 {
    @Test
    public void proxyTest() {
        //OrderService2 orderService2 = new OrderServiceImpl2();
        OrderService2 orderService2 = new OrderServiceImplSub2();//子类功能扩展增强
        orderService2.generate();
        orderService2.detail();
        orderService2.modify();
    }
    /*
        订单已生成
        generate()操作耗时 = 1235
        订单信息如下：******
        detail()操作耗时 = 2541
        订单已修改
        modify()操作耗时 = 1020
    */
}
