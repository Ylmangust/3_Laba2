/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2;
 import GearFactory.*;
/**
 *
 * @author Регина
 */
public class OrkBuilderFactory {

    public static OrkBuilder createBuilder(String tribe) {
        switch (tribe) {
            case "Dol Guldur":
                return new DolGuldurOrkBuilder(new DolGuldurGearFactory());
            case "Mordor":
                return new MordorOrkBuilder(new MordorGearFactory());
            case "Misty Mountains":
               return new MistyMountainsOrkBuilder(new MistyMountainsGearFactory());
        }
        return null;
    }
}
