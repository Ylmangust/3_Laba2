/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2;

import Armor.LeatherArmor;
import Banner.MistyMountainsBanner;
import Weapon.Axe;

/**
 *
 * @author Регина
 */
public class MistyMountainsGearFactory implements OrkGearFactory{

    @Override
    public Weapon.Weapon createWeapon() {
        return new Axe();
    }

    @Override
    public Armor.Armor createArmor() {
        return new LeatherArmor();
    }

    @Override
    public Banner.Banner createBanner() {
        return new MistyMountainsBanner();
    }
    
}
