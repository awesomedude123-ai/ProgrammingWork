package com.sri.challenge.abstractclass;

public class MyLinkedList implements NodeList{
    private ListItem root;

    public MyLinkedList(ListItem root){
        this.root=root;
    }

    public ListItem getRoot() {
        return root;
    }

    public boolean addItem(ListItem anotherRoot){
        if(root.leftLink.compareTo(anotherRoot)==0){
            return false;
        }else{
            boolean isLarger=false;
            ListItem currentNode=root;
            ListItem farItem;
            while(currentNode!=null){
                farItem=currentNode.next();currentNode=currentNode.next();
            }
            farItem=currentNode.previous();
            while(isLarger==false){
                if(currentNode.previous().compareTo(anotherRoot)>0 || currentNode==null){
                    isLarger=true;root.setNext(anotherRoot);
                }else{
                    currentNode=currentNode.previous();
                }
            }
            return true;
        }
    }

    public boolean removeItem(ListItem listItem){
        if(listItem.value!=null){

        }
        return true;
    }
}
