package com.wyjun.Proxy;

import com.wyjun.proxy.service3.OrderService3;
import com.wyjun.proxy.service3.OrderServiceImpl3;
import com.wyjun.proxy.service3.OrderServiceProxy3;
import org.junit.jupiter.api.Test;

public class ProxyTest3 {
    @Test
    public void proxyTest() {

        OrderService3 orderService3 = new OrderServiceProxy3(new OrderServiceImpl3());
        orderService3.generate();
        orderService3.detail();
        orderService3.modify();
    }
    /*
        订单已生成
        generate()操作耗时 = 1234
        订单信息如下：******
        detail()操作耗时 = 2542
        订单已修改
        modify()操作耗时 = 1011
    */
}
