package com.wyjun.bean.cutomer;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor // 这种方式底层会自动生成一个带有参数的构造方法。
public class Customer2 {
    //这种方式也可以完成注入。但是这个注入是基于按照类型进行自动装配。
    private final Long id;
    private final String name;
    private final int age;
}
