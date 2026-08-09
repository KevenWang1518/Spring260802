package com.wyjun.bean.entity;

import java.util.Arrays;

public class Order {
    private Goods[] goodsArray;

    public void setGoodsArray(Goods[] goodsArray) {
        this.goodsArray = goodsArray;
    }

    @Override
    public String toString() {
        return "Order{" +
                "goodsArray=" + Arrays.toString(goodsArray) +
                '}';
    }
}
