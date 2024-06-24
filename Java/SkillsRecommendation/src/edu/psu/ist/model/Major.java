package edu.psu.ist.model;

public class Major{

    private String name;

    private String description;
    private int creditHours;
    private String industry;

    private static int id=0;

    public Major(String name, String description, int creditHours, String industry) {
        this.name = name;
        this.description = description;
        this.creditHours = creditHours;
        this.industry = industry;
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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }


    @Override
    public boolean equals(Object object) {
        Major major = (Major) object;
        return this.name.equals(major.getName());
    }

    @Override
    public String toString() {
        return "Name: "+this.name+"\nDescription: "+this.description +"\nCreditHours: "+this.creditHours + "\nIndustry: " + this.industry;
    }
}
