package com.wyjun.Proxy;

import com.wyjun.proxy.service.*;
import org.junit.jupiter.api.Test;

public class ProxyTest4_Util {
    @Test
    public void dynamicProxyTest() {
        //创建一个目标对象
        ProductService target = new ProductServiceImpl();

        //创建一个代理对象（其调用ProxyUtil实现）
        ProductService proxy = (ProductService) ProxyUtil.getProxyForTimer(target);

        //通过调用代理对象的代理方法间接执行目标对象的目标方法。
        //执行这里的时候，注册在调用处理器中的invoke回调会被自动调用。
        System.out.println(proxy.getProduct());
        proxy.removeById();

        System.out.println("----------------------------------------------------");

        //创建另一个目标对象
        OrderService target2 = new OrderServiceImpl();

        //创建另一个代理对象（其调用ProxyUtil实现）
        OrderService orderService = (OrderService) ProxyUtil.getProxyForTimer(target2);

        //通过调用代理对象的代理方法间接执行目标对象的目标方法。
        //执行这里的时候，注册在调用处理器中的invoke回调会被自动调用。
        orderService.generate();
        orderService.detail();
        orderService.modify();
    }
    /*
        正在读取商品信息......
        com.wyjun.proxy.service.ProductServiceImpl's getProduct() running : 3013ms
        iPhone Pro Max Ultra
        正在删除商品信息......
        com.wyjun.proxy.service.ProductServiceImpl's removeById() running : 2006ms
        ----------------------------------------------------
        订单已生成
        com.wyjun.proxy.service.OrderServiceImpl's generate() running : 1235ms
        订单信息如下：******
        com.wyjun.proxy.service.OrderServiceImpl's detail() running : 2543ms
        订单已修改
        com.wyjun.proxy.service.OrderServiceImpl's modify() running : 1024ms
     */
}
