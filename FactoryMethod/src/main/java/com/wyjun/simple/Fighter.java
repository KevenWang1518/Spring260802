package com.wyjun.simple;

// 具体产品角色
// 战斗机
public class Fighter extends Weapon{
    @Override
    public void attack() {
        System.out.println("战斗机发射导弹！");
    }
}