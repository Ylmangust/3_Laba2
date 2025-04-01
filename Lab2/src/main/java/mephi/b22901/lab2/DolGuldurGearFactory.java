/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2;

import Armor.ChainMail;
import Banner.DolGuldurBanner;
import Weapon.Spear;
/**
 *
 * @author Регина
 */
public class DolGuldurGearFactory implements OrkGearFactory{

    @Override
    public Weapon.Weapon createWeapon() {
        return new Spear();
    }

    @Override
    public Armor.Armor createArmor() {
        return new ChainMail();
    }

    @Override
    public Banner.Banner createBanner() {
        return new DolGuldurBanner();
    }
    
}
