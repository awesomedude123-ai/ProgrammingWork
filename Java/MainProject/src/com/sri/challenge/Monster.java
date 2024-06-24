package com.sri.challenge;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{

    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints,int strength){
        this.name=name;
        this.hitPoints=hitPoints;
        this.strength=strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return a;
    }

    @Override
    public void read(List<String> name) {
        if(name.size()>0 && name!=null){
            setName(name.get(0));
            setHitPoints(Integer.parseInt(name.get(1)));
            setStrength(Integer.parseInt(name.get(2)));
        }
    }

    public String toString(){
        return "Monster{name='"+name+"', hitpoints="+hitPoints+", strength="+strength+"}";
    }
}
