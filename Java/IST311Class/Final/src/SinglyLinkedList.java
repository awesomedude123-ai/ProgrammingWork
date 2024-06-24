public class SinglyLinkedList <T extends Comparable>{
    Node<T> head;

    public SinglyLinkedList(){
        this.head = null;
    }

    public Node<T> append(T data){
        //appending a node at the end of the linked list
        Node<T> toAppend = new Node(data);
        if(this.head == null)
            this.head = toAppend;
        else{
            Node<T> tempNode = this.head;
            while(tempNode.next != null)
                tempNode = tempNode.next;
            tempNode.next = toAppend;
        }
        return toAppend;
    }
    public Node<T> Enqueue(T data){
        Node<T> temp = this.head;
        if(this.head == null){
            append(data);
            return this.head;
        }else{
            while(temp.next != null){
                temp=temp.next;
            }
            Node<T> newNode = new Node<T>(data);
            temp.next = newNode;
            return newNode;
        }
    }
    public Node<T> Dequeue() {
        Node<T> returnedNode = this.head;
        this.head = this.head.next;
        returnedNode.next=null;
        return returnedNode;
    }
}