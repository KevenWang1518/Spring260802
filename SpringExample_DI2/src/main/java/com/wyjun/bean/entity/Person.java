package com.wyjun.bean.entity;

import java.util.Arrays;

public class Person {
    //爱好
    private String[] hobbies;

    @Override
    public String toString() {
        return "Person{" +
                "hobbies=" + Arrays.toString(hobbies) +
                '}';
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
