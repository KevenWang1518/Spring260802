package com.wyjun.simple;

//客户端程序。
//对于客户端来说是不需要关心具体产品的创建逻辑。
public class Client {
    public static void main(String[] args) {

        //小瑕疵:虽然不需要关心具体产品的创建细节，但是需要关心是具体的哪一个工厂。
        WeaponFactory weaponFactory1 = new TankFactory();
        Weapon weapon1 = weaponFactory1.getWeapon();
        weapon1.attack();

        WeaponFactory weaponFactory2 = new FighterFactory();
        Weapon weapon2 = weaponFactory2.getWeapon();
        weapon2.attack();

        WeaponFactory weaponFactory3 = new DaggerFactory();
        Weapon weapon3 = weaponFactory3.getWeapon();
        weapon3.attack();
    }
}
