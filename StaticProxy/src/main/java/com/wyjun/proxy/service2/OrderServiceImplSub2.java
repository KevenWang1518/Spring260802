package com.wyjun.proxy.service2;

//采用继承的方式对父类进行功能的扩展和增强。
public class OrderServiceImplSub2 extends OrderServiceImpl2 {
    @Override
    public void generate() {
        long startTime = System.currentTimeMillis();
        super.generate();
        long endTime = System.currentTimeMillis();
        System.out.println("generate()操作耗时 = " + (endTime - startTime));
    }

    @Override
    public void detail() {
        long startTime = System.currentTimeMillis();
        super.detail();
        long endTime = System.currentTimeMillis();
        System.out.println("detail()操作耗时 = " + (endTime - startTime));
    }

    @Override
    public void modify() {
        long startTime = System.currentTimeMillis();
        super.modify();
        long endTime = System.currentTimeMillis();
        System.out.println("modify()操作耗时 = " + (endTime - startTime));
    }
}
