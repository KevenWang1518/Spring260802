package com.wyjun;

import com.wyjun.bean.cutomer.Customer;
import com.wyjun.bean.cutomer.Customer2;
import org.junit.jupiter.api.Test;

public class SpringLombokTest {
    @Test
    void springLombokTest1() {
        Customer customer = new Customer();

        customer.setId(1111L);
        customer.setName("ZhangSan");
        customer.setAge(20);

        System.out.println(customer.toString());
    }//Customer(id=1111, name=ZhangSan, age=20)

    @Test
    void springLombokTest2() {
        Customer2 customer = new Customer2(2222L, "Lisi", 30);
        System.out.println(customer.toString());
    }//Customer2(id=2222, name=Lisi, age=30)
}
