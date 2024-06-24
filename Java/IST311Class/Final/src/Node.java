public class Node <T> {
    protected T data;
    Node<T> next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }
}