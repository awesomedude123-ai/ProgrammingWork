package edu.psu.ist.controller;

public interface SkillManager {
    abstract boolean remove(String name);
    abstract void update(int id, String param, String newValue);
    abstract String view();
}
