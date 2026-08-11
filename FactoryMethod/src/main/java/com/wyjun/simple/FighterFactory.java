package com.wyjun.simple;

//具体工厂
public class FighterFactory implements WeaponFactory {
    @Override
    public Weapon getWeapon() {
        return new Fighter();
    }
}
