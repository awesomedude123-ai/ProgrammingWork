package model;

import java.util.ArrayList;
import java.util.List;

public class NavigableDocModel<T> {
    private Node left;
    private Node right;

    public NavigableDocModel(){
        this.left=null;
        this.right=null;
    }//end constructor

    //O(1)
    public void insertNewItemRt(T item){
        Node filler = new Node();
        filler.data=item;
        if(right==null){
            filler.next=null;
            right=filler;
        }else{
            filler.next=right;
            right=filler;
        }//end if else statement
    }//end method

    //O(n)
    @Override
    public String toString() {
        String value = "";
        Node first=left;
        if(first!=null){
            while(first!=null){
                value = value + first.data+" ";
                first=first.next;
            }//end while statement
        }//end if statement
        value = value + "$ ";
        first=right;
        if(first!=null){
            while(first!=null){
                value = value + first.data+" ";
                first=first.next;
            }//end while statement
        }//end if statement

        return value.stripTrailing();
    }//end toString method


    //O(n)
    public void forward(){
        if(right==null){
            throw new IllegalStateException("There is nothing in the right side");
        }else{
            Node example = new Node();
            example.data=right.data;
            example.next=null;
            right=right.next;
            if(left==null){
                left=example;
            }else{
                List<Node<T>> list= new ArrayList<>();
                while(left!=null){
                    Node layer = new Node();
                    layer.data=left.data;layer.next=left.next;
                    list.add(layer);
                    left=left.next;
                }
                left=example;
                for(int i=list.size()-1;i>=0;i--){
                    Node layer = list.get(i);
                    layer.next=left;
                    left=layer;
                }//end for loop
            }//end if else statement
        }//end if else statement
    }//end forward method

    //O(1)
    public int lenBeforeBar(){
        String str = toString();
        String[] arr = str.split("\\$");
        return arr[0].length()/2;
    }
    //O(1)
    public int lenAfterBar(){
        String str = toString();
        String[] arr = str.split("\\$");
        return arr[1].length()/2;
    }
    //O(n)
    public Pair<Side, Integer> contains(T item){
        int left1=isThere(this.left,item,0);
        int right1=isThere(this.right,item,0);
        if(left1==-1){
            if(right1==-1){
                return new Pair(Side.NONE,-1);
            }else{
                return new Pair(Side.RIGHT,right1);
            }
        }else{
            if(right1==-1){
                return new Pair(Side.LEFT,left1);
            }else{
                return new Pair(Side.BOTH,left1);
            }
        }
    }//end method

    private int isThere(Node item, T itemLookingFor,int index){
        if(item==null){
            return -1;
        }
        if(itemLookingFor.equals(item.data)){
            return index;
        }else{
            return isThere(item.next,itemLookingFor,index+1);
        }
    }

    public void reset(){
        List<Node<T>> list= new ArrayList<>();
        while(left!=null){
            Node layer = new Node();
            layer.data=left.data;layer.next=left.next;
            list.add(layer);
            left=left.next;
        }
        for(int i=list.size()-1;i>=0;i--){
            insertNewItemRt(list.get(i).data);
        }
    }

}//end class
