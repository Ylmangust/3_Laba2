/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mephi.b22901.lab2;

import GearFactory.DolGuldurGearFactory;

/**
 *
 * @author Регина
 */
public class Lab2 {

    public static void main(String[] args) {
        OrkDirector director = new OrkDirector();
        DolGuldurGearFactory gear = new DolGuldurGearFactory();
        OrkBuilder builder = new DolGuldurOrkBuilder(gear);
        director.setOrkBuilder(builder);
        director.createScoutOrk();
        System.out.println(director.getOrk().toString());
    }
}
