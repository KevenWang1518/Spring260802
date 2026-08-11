package com.wyjun.bean;

import java.util.Date;
public class User {
    private  Date birthday;

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "birthday=" + birthday +
                '}';
    }
}
