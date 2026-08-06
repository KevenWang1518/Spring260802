package com.wyjun.bean.service;

import com.wyjun.bean.dao.OrderDao;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    //构造注入（提供有参构造方法）
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void save() {
        System.out.println("订单开始保存");
        orderDao.insert();
        System.out.println("订单保存成功");

    }
}
