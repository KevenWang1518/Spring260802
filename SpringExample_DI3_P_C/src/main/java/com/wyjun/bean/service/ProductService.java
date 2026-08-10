package com.wyjun.bean.service;

import com.wyjun.bean.dao.ProductDao;

public class ProductService {
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void save() {
        productDao.insert();
    }

    @Override
    public String toString() {
        return "ProductService{" +
                "productDao=" + productDao +
                '}';
    }
}
