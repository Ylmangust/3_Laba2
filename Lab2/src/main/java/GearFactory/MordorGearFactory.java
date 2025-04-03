/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GearFactory;

import Armor.SteelArmor;
import Banner.MordorBanner;
import Weapon.HeavySword;

/**
 *
 * @author Регина
 */
public class MordorGearFactory implements OrkGearFactory{

    @Override
    public Weapon.Weapon createWeapon() {
        return new HeavySword();
    }

    @Override
    public Armor.Armor createArmor() {
        return new SteelArmor();
    }

    @Override
    public Banner.Banner createBanner() {
        return new MordorBanner();
    }
    
}
