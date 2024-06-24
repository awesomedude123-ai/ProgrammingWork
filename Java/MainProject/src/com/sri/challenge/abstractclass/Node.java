package com.sri.challenge.abstractclass;

public class Node extends ListItem{
    public Node(Object value) {
        super(value);
    }

    @Override
    protected ListItem next() {
        return this.rightLink;
    }

    @Override
    protected ListItem setNext(ListItem rightLink) {
        this.rightLink=rightLink;
        return this.rightLink;
    }

    @Override
    protected ListItem previous() {
        return this.leftLink;
    }

    @Override
    protected ListItem setPrevious(ListItem leftLink) {
        this.leftLink=leftLink;
        return this.leftLink;
    }

    @Override
    protected int compareTo(ListItem item) {
        return this.value.toString().compareTo(item.value.toString());
    }
}
