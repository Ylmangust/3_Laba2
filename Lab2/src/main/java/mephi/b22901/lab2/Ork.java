/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2;

/**
 *
 * @author Регина
 */
public class Ork {

    private String name;
    private String weapon;
    private String armor;
    private String banner = "";
    private int strength;
    private int agility;
    private int intelligence;
    private int hp;

    public void setName(String name) {
        this.name = name;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
//return name + " " + weapon + " " + armor + " " + banner + " Strength: " + strength + " Agility: " + agility + " Intelligence: " + intelligence + " HP: " + hp;
    }

}
