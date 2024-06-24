package edu.psu.ist.controller;

import edu.psu.ist.model.Category;

import java.util.ArrayList;

public class CategoryController {
    ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void add(String name, String description) {
        Category category = new Category(name, description);
        this.categories.add(category);
    }

    public void remove(String name){
        for(Category category : categories){
            if(category.getName().equals(name)){
                this.categories.remove(category);
                break;
            }
        }
    }
}
