/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GearFactory;

import Weapon.Bow;

/**
 *
 * @author Регина
 */
public interface OrkGearFactory {
    public Weapon.Weapon createWeapon();
    public Armor.Armor createArmor();
    public Banner.Banner createBanner();
    default public Weapon.Weapon createBow(){
        return new Bow();
    }
}
