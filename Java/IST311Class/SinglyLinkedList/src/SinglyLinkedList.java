public class SinglyLinkedList<T extends Comparable<T>> {
    public Node<T> head;

    public Node<T> tail;
    public SinglyLinkedList() {
        this.head = null;
    }

    public Node<T> append(T newValue){
        Node<T> append = new Node<>(newValue);
        if(head == null){
            this.head = append;
            this.tail = append;
        }else{
            Node<T> temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }

            temp.next = append;
            tail = append;
        }
        return append;
    }//end append

    public boolean contains(T data){
        Node<T> toTest = this.head;
        while(toTest!=null){
            if(toTest.val.compareTo(data)==0){
                return true;
            }else{
                toTest = toTest.next;
            }
        }
        return false;
    }

    public Node<T> delete(T data){
        Node<T> toDelete = null;
        if(this.head == null){
            return null;
        }
        if(this.head.val.compareTo(data)==0){
            toDelete = this.head;
            this.head = this.head.next;
            return toDelete;
        }

        Node<T> current = this.head;
        while(current.next!=null){
            if(current.next.val.compareTo(data)==0){
                toDelete = current.next;
                current.next=toDelete.next;
                toDelete.next=null;
                return toDelete;
            }
            current = current.next;
        }
        return toDelete;
    }

    public Node<T> insert(int location, T data){
        Node<T> toInsert = new Node<T>(data);
        if(location==0){
            toInsert.next = this.head;
            this.head = toInsert;
            return toInsert;
        }
        Node<T> current = this.head;
        location--;
        while (location!=0){
            if(current.next==null){
                return null;
            }else{
                current=current.next;
            }
            location--;
        }
        Node<T> currentNext = current.next;
        toInsert.next=currentNext;
        current.next=toInsert;
        return toInsert;
    }

    public int getIndex(T data){
        int index = 0;
        Node<T> current = this.head;
        while(current.val!=data){
            index++;
            current = current.next;
            if(current.val==data){
                return index;
            }else if(current.next==null){
                return -1;
            }

        }
        return index;
    }


    public Node<T> popStack() {
        Node<T> headerNext = this.head.next;
        Node<T> current = this.head;
        current.next=null;
        this.head = headerNext;
        return current;
    }

    public Node<T> pushStack(T data){
        Node<T> newNode = new Node<T>(data);
        newNode.next = this.head;
        this.head = newNode;
        return newNode;
    }

    public Node<T> dequeue() {
        if(this.head==null){
            return null;
        }else{
            Node<T> newNode = this.head;
            this.head = this.head.next;
            return newNode;
        }
    }//end dequeue

    public Node<T> queue(T newValue) {
        Node<T> newNode = new Node<T>(newValue);
        if(tail==null) {
            tail = newNode;
        }else{
            tail.next=newNode;
            tail=tail.next;
        }
        return newNode;

    }

    @Override
    public String toString() {
        Node<T> toPrint = this.head;

        StringBuilder sb = new StringBuilder();

        while(toPrint != null){
            sb.append(toPrint.val);
            sb.append(" -> ");

            toPrint = toPrint.next;
        }

        sb.append("NULL");
        return sb.toString();
    }
}
