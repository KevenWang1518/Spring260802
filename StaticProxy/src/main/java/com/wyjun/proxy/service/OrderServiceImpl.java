package com.wyjun.proxy.service;

public class OrderServiceImpl implements OrderService {
    @Override
    public void generate() {
        //直接修改代码，添加计时功能，违背OCP原则。
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已生成");
        long endTime = System.currentTimeMillis();
        System.out.println("generate()操作耗时 = " + (endTime - startTime));
    }

    @Override
    public void detail() {
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(2541);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单信息如下：******");
        long endTime = System.currentTimeMillis();
        System.out.println("detail()操作耗时 = " + (endTime - startTime));
    }

    @Override
    public void modify() {
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(1010);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已修改");
        long endTime = System.currentTimeMillis();
        System.out.println("modify()操作耗时 = " + (endTime - startTime));
    }
}
