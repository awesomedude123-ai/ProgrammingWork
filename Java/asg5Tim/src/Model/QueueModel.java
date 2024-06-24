package Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueModel<T> {
    private Queue queue;
    public QueueModel(){
        this.queue=new LinkedList<>();
    }//end constructor

    //O(1)
    public void enqueue(T value){
        this.queue.add(value);
    }//end method

    //O(1)
    public T dequeue(){
        T value = (T)this.queue.poll();
        return value;
    }//end method

    //O(1)
    public T peekFront(){
        return (T)this.queue.peek();
    }//end method

    //O(1)
    public T peekRear(){
        List<T> sub=new LinkedList<>(queue);
        return sub.get(sub.size()-1);
    }//end method

    //O(1)
    public Queue getWrappedQueue(){
        return this.queue;
    }//end method

    //O(1)
    public void clear(){
        this.queue.clear();

    }//end method

    @Override
    public String toString() {
        return this.queue.toString();
    }
}//end class
