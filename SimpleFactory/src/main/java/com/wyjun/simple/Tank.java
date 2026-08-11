package com.wyjun.simple;

// 具体产品角色
// 坦克
public class Tank extends Weapon{
    @Override
    public void attack() {
        System.out.println("坦克开炮！");
    }
}