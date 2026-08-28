package com.wyjun.Proxy;

import com.wyjun.proxy.service.*;
import org.junit.jupiter.api.Test;

public class ProxyTest5_Util {
    @Test
    public void dynamicProxyTest() {
        //创建一个目标对象
        ProductService target = new ProductServiceImpl();

        //创建一个代理对象（其调用ProxyUtil实现）
        ProductService proxy = (ProductService) ProxyUtil.getProxyForTransaction(target);

        //通过调用代理对象的代理方法间接执行目标对象的目标方法。
        //执行这里的时候，注册在调用处理器中的invoke回调会被自动调用。
        System.out.println(proxy.getProduct());
        proxy.removeById();

        System.out.println("----------------------------------------------------");

        //创建另一个目标对象
        OrderService target2 = new OrderServiceImpl();

        //创建另一个代理对象（其调用ProxyUtil实现）
        OrderService orderService = (OrderService) ProxyUtil.getProxyForTransaction(target2);

        //通过调用代理对象的代理方法间接执行目标对象的目标方法。
        //执行这里的时候，注册在调用处理器中的invoke回调会被自动调用。
        orderService.generate();
        orderService.detail();
        orderService.modify();
    }
    /*
        开启事务
        正在读取商品信息......
        iPhone Pro Max Ultra
        开启事务
        正在删除商品信息......
        ----------------------------------------------------
        开启事务
        订单已生成
        开启事务
        订单信息如下：******
        开启事务
        订单已修改
     */
}
