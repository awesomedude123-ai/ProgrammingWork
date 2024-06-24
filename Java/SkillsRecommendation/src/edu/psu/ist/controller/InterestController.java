package edu.psu.ist.controller;

import edu.psu.ist.model.Interest;

import java.util.ArrayList;

public class InterestController {

    private ArrayList<Interest> interests;

    private InterestFilter filter;

    private String filterText;

    public ArrayList<Interest> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<Interest> interests) {
        this.interests = interests;
    }

    public InterestFilter getFilter() {
        return filter;
    }

    public void setFilter(InterestFilter filter) {
        this.filter = filter;
    }

    public String getFilterText() {
        return filterText;
    }

    public void setFilterText(String filterText) {
        this.filterText = filterText;
    }

    public ArrayList<Interest> filter(InterestFilter filter, String filterText) {
        ArrayList<Interest> li = new ArrayList<Interest>();
        switch (filter) {
            case ID -> {
                for(Interest interest : interests){
                    if(interest.getId() == Integer.parseInt(filterText)){
                        li.add(interest);
                    }//end if statement
                }//end for loop
            }//end case ID
            case NAME -> {
                for(Interest interest : interests){
                    if(interest.getName().equals(filterText)){
                        li.add(interest);
                    }//end if statement
                }//end for loop
            }//end case NAME
            case CATEGORY -> {
                for(Interest interest : interests){
                    if(interest.getCategory().equals(filterText)){
                        li.add(interest);
                    }//end if statement
                }//end for loop
            }//end case CATEGORY
        }//end switch statement
        return li;
    }//end filter method

    public void add(String name, String description, String category) {
        Interest interest = new Interest(name, description, category);
        interests.add(interest);
    }

    public void remove(int id){
        interests.remove(id);
    }

    public void modify(int id, String type, String newValue){
        Interest interest = interests.get(id);
        switch(type) {
            case "Name" -> interest.setName(newValue);
            case "Description" -> interest.setDescription(newValue);
            case "Category" -> interest.setCategory(newValue);
        }
    }//end modify method
}
