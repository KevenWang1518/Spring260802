package com.wyjun.service;

import org.springframework.stereotype.Service;

//目标类
@Service("orderService") //纳入IoC容器的管理
public class OrderService {
    //目标方法1
    public void generate() {
        System.out.println("业务订单己生成......");
    }

    //目标方法2
    public Integer getOrderNumber() {
        System.out.println("返回订单数量......");
        //System.out.println(10/0);//人为制造除零异常，测试异常通知
        return 10;
    }
}
