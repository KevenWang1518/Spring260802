package com.wyjun.simple;

//客户端程序。
public class Client {
    public static void main(String[] args) {
        //客户端程序不需要关心对象的创建细节。
        //需要对象，就去找工厂。工厂给你造。降低耦合度
        Weapon weapon1 = WeaponFactory.getWeapon("TANK");
        weapon1.attack();

        Weapon weapon2 = WeaponFactory.getWeapon("FIGHTER");
        weapon2.attack();

        Weapon weapon3 = WeaponFactory.getWeapon("DAGGER");
        weapon3.attack();
    }
}
