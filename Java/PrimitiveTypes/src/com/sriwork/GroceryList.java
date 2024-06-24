package com.sriwork;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList=new ArrayList<String>();

    public void addGroceryItem(String item){
        int y=0;
        String x=(y==0)? "hi":"bye";
        groceryList.add(item);
    }

    public void printGroceryList(){
        groceryList.forEach(x -> System.out.println(x));
    }

    public void modifyGroceryList(int position, String newItem){
        groceryList.set(position,newItem);
    }

    public void removeGroceryItem(int position){
        groceryList.remove(position);
    }

    public String findItem(String item){
        if(groceryList.contains(item)){
            return item;
        }else{
            return null;
        }
    }
}
