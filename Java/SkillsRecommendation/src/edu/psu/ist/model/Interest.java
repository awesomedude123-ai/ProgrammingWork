package edu.psu.ist.model;

public class Interest{

    private String name;

    private String description;
    private String category;

    private static int id=0;

    public Interest(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
        id++;
    }//end constructor

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        Interest interest = (Interest) obj;
        return this.name.equals(interest.getName());
    }

    @Override
    public String toString() {
        return "Name: "+this.name+"\nDescription: "+ this.description + "Category: "+category;
    }
}//end class Interest
