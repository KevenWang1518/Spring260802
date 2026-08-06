package com.wyjun.bean.controller;

import com.wyjun.bean.service.OrderService;
import com.wyjun.bean.service.UserService;

public class OrderController2 {
    private OrderService orderService;
    private UserService userService;

    //构造注入（提供1个参数的有参构造方法）
    public OrderController2(OrderService orderService) {
        this.orderService = orderService;
    }
    //构造注入（提供2个参数的有参构造方法）
    public OrderController2(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    public void save() {
        System.out.println("Controller save order begin");
        orderService.save();
        userService.save();
        System.out.println("Controller save order end");
    }

}
