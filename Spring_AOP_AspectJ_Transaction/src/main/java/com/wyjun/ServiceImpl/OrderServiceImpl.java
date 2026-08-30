package com.wyjun.ServiceImpl;

import com.wyjun.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    //后续使用AOP添加事务。

    @Override
    public void saveOrder() {
        System.out.println("正在生成订单信息......");
    }

    @Override
    public void searchOrder() {
        System.out.println("正在查询订单信息......");
    }
}
