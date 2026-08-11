package com.wyjun.simple;

//具体工厂
public class DaggerFactory implements WeaponFactory {
    @Override
    public Weapon getWeapon() {
        return new Dagger();
    }
}
