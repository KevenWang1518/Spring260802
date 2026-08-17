package com.wyjun.Proxy;

import com.wyjun.proxy.service.OrderService;
import com.wyjun.proxy.service.OrderServiceImpl;
import org.junit.jupiter.api.Test;

public class ProxyTest {
    @Test
    public void proxyTest() {
        OrderService orderService = new OrderServiceImpl();
        orderService.generate();
        orderService.detail();
        orderService.modify();
    }
    /*
        订单已生成
        generate()操作耗时 = 1236
        订单信息如下：******
        detail()操作耗时 = 2542
        订单已修改
        modify()操作耗时 = 1017
    */
}
