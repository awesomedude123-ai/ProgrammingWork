package edu.psu.ist.controller;

import edu.psu.ist.model.Major;

import java.util.ArrayList;

public class MajorController {
    private ArrayList<Major> majors;

    private MajorFilter filter;

    private String filterText;


    public ArrayList<Major> getMajors() {
        return majors;
    }

    public void setMajors(ArrayList<Major> majors) {
        this.majors = majors;
    }

    public MajorFilter getFilter() {
        return filter;
    }

    public void setFilter(MajorFilter filter) {
        this.filter = filter;
    }

    public String getFilterText() {
        return filterText;
    }

    public void setFilterText(String filterText) {
        this.filterText = filterText;
    }

    public ArrayList<Major> filter(MajorFilter filter, String filterText) {
        ArrayList<Major> li = new ArrayList<>();
        switch(filter){
            case ID -> {
                for(Major major: majors){
                    if(major.getId() == Integer.parseInt(filterText)){
                        li.add(major);
                    }
                }
            }
            case NAME -> {
                for(Major major : majors){
                    if(major.getName().equals(filterText)) {
                        li.add(major);
                    }//end if statement
                }//end for loop
            }//end case NAME
            case CREDITHOURS -> {
                for(Major major : majors){
                    if(major.getCreditHours() == Integer.parseInt(filterText)){
                        li.add(major);
                    }//end if statement
                }//end for loop
            }//end case CREDITHOURS
            case INDUSTRY -> {
                for(Major major : majors){
                    if(major.getIndustry().equals(filterText)){
                        li.add(major);
                    }//end if statement
                }//end for loop
            }//end case INDUSTRY
        }//end switch statement
        return li;
    }//end filter method

    public void add(String name, String description, int creditHours, String industry) {
        Major major = new Major(name, description, creditHours, industry);
        majors.add(major);
    }//end add method

    public void remove(String name){
        Major major = null;
        for(Major major1 : majors){
            if(major1.getName().equals(name)){
                major = major1;
            }
        }
        if(major != null){
            majors.remove(major);
        }
    }//end remove method

    public void modify(int id, String type, String newValue){
        Major major = null;
        for(Major major1 : majors){
            if(major1.getId() == id){
                major = major1;
            }
        }
        switch(type){
            case "Name" -> {
                major.setName(newValue);
            }
            case "Description" -> {
                major.setDescription(newValue);
            }
            case "CreditHours" -> {
                major.setCreditHours(Integer.parseInt(newValue));
            }
            case "Industry" -> {
                major.setIndustry(newValue);
            }
        }
    }//end modify method
}
