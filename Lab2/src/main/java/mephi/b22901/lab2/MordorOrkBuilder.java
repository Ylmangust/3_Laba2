/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2;

import GearFactory.OrkGearFactory;
import java.util.Random;

/**
 *
 * @author Регина
 * @param <T>
 */
public class MordorOrkBuilder  <T extends OrkGearFactory> extends OrkBuilder<T>{

    public MordorOrkBuilder(T gearFactory) {
        super(gearFactory);
    }

    @Override
    public void setAttributes() {
        Random random = new Random();
        this.ork.setStrength((int)(random.nextInt(101)*(1+coef)));
        this.ork.setAgility(((int)(random.nextInt(101)*(1-coef))));
        this.ork.setHp(random.nextInt(151)+50);
        this.ork.setIntelligence(random.nextInt(50)+1); 
    }
    
}
