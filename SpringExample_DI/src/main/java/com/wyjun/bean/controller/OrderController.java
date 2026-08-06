package com.wyjun.bean.controller;

import com.wyjun.bean.service.OrderService;

public class OrderController {
    private OrderService orderService;

    //构造注入（提供有参构造方法）
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void save() {
        System.out.println("Controller save order begin");
        orderService.save();
        System.out.println("Controller save order end");
    }

}
