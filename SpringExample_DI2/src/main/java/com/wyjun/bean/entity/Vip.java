package com.wyjun.bean.entity;

public class Vip {
    private String name;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public Vip() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
