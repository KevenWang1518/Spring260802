package com.wyjun.proxy.service4;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

//代理类
//代理模式中:代理类和目标类要实现同一个/多个接口。why?客户端无感知。
@Service
public class OrderServiceProxy4 implements OrderService4 {

    //目标类。
    //不要编写具体的类，要编写接口类型，这样表示 OrderServiceProxy4可以代理 OrderService4接口下的所有子类。
    @Resource(name = "orderServiceImpl4")
    private OrderService4 target;

    @Override
    public void generate() {
        long startTime = System.currentTimeMillis();
        target.generate();
        long endTime = System.currentTimeMillis();
        System.out.println("generate()操作耗时 = " + (endTime - startTime));
    }

    @Override
    public void detail() {
        long startTime = System.currentTimeMillis();
        target.detail();
        long endTime = System.currentTimeMillis();
        System.out.println("detail()操作耗时 = " + (endTime - startTime));
    }

    @Override
    public void modify() {
        long startTime = System.currentTimeMillis();
        target.modify();
        long endTime = System.currentTimeMillis();
        System.out.println("modify()操作耗时 = " + (endTime - startTime));
    }
}
