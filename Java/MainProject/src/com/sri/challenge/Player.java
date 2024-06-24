package com.sri.challenge;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable{

    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints,int strength){
        this.name=name;
        this.hitPoints=hitPoints;
        this.strength=strength;
        this.weapon="Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        List<String> a=new ArrayList<String>();
        a.add(name);
        a.add(Integer.toString(hitPoints));
        a.add(Integer.toString(strength));
        a.add(weapon);
        return a;
    }

    @Override
    public void read(List<String> name) {
        if(name.size()>0 && name!=null){
            setName(name.get(0));
            setHitPoints(Integer.parseInt(name.get(1)));
            setStrength(Integer.parseInt(name.get(2)));
            setWeapon(name.get(3));
        }
    }

    public String toString(){
        return "Player{name='"+this.name+"', hitPoints="+hitPoints+", strength="+this.strength+", weapon='"+this.weapon+"'}";
    }
}
