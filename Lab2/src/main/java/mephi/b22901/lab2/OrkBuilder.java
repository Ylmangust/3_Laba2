/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2;

import GearFactory.OrkGearFactory;

/**
 *
 * @author Регина
 */
abstract class OrkBuilder <T extends OrkGearFactory>{ 
    protected Ork ork;
    protected T gearFactory;
    protected final double coef = 0.3;
    
    public OrkBuilder(T gearFactory) {
        this.gearFactory = gearFactory;
    }
    
    public void createNewOrk() {   ork = new Ork(); }
    public Ork getOrk() {   return ork; }
    
    public void setName(){
        ork.setName(new OrkNames().generateName());
    }
    public abstract void setAttributes();
    
    public void setGear(){
        ork.setWeapon(gearFactory.createWeapon().getName());
        ork.setArmor(gearFactory.createArmor().getName());
    };
    public void setBanner(){
        ork.setArmor(gearFactory.createBanner().getName());
    };
    public void setBow(){
        ork.setWeapon(gearFactory.createBow().getName());
    };
}
