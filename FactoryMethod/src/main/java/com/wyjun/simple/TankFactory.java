package com.wyjun.simple;

//具体工厂
public class TankFactory implements WeaponFactory {
    @Override
    public Weapon getWeapon() {
        return new Tank();
    }
}
