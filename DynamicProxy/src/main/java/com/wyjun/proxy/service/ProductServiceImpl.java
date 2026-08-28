package com.wyjun.proxy.service;

import java.util.concurrent.TimeUnit;

public class ProductServiceImpl implements ProductService{
    @Override
    public String getProduct() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("正在读取商品信息......");
        return "iPhone Pro Max Ultra";
    }

    @Override
    public void removeById() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("正在删除商品信息......");
    }
}
