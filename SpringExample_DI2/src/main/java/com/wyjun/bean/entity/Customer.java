package com.wyjun.bean.entity;

import java.util.List;
public class Customer {
    private List<String> names;

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "names=" + names +
                '}';
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
