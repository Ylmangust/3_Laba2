/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2;

import java.util.Random;

/**
 *
 * @author Регина
 */
public class OrkNames {

    private String[] names = {
        "Azog", "Balcmeg", "Boldog", "Bolg", "The Great Goblin", "Golfimbul", 
        "Gorbag", "Gothmog", "Grishnakh", "Lagduf", "Lug", "Lugdush", "Lurtz", 
        "Mauhur","Muzgash", "Narzug", "Orcobal", "Othrod", "Radbug", 
        "Snaga", "Ugluk","Ufthak", "Fimbul", "Shagrat", "Sharku", "Yazneg",
        "Durz", "Buzgwog", "Vitgut", "Maragul", "Lorimph", "Murgmog",
        "Gharrgak", "Grat", "Mugslag", "Yroh", "Vagungad", "Zarod",
        "Gonkulg", "Lurub", "Islaq", "Rugdorn"    };
    
    public String generateName(){
        Random random = new Random();
        String orkName = names[random.nextInt(names.length)];
        return orkName;
    }
}
