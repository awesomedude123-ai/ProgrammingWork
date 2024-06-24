package com.sri.challenge.abstractclass;

public abstract class ListItem {
    protected ListItem rightLink=null;
    protected ListItem leftLink=null;
    Object value;

    public ListItem(Object value){
        this.value=value;
    }//end Constructor

    protected abstract ListItem next();
    protected abstract ListItem setNext(ListItem rightLink);
    protected abstract ListItem previous();
    protected abstract ListItem setPrevious(ListItem leftLink);
    protected abstract int compareTo(ListItem item);

    public Object getValue(){
        return this.value;
    }

    public void setValue(Object value){
        this.value=value;
    }
}
