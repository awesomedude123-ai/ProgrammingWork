import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SinglyLinkedListTest {
    @Test
    public void enQueue(){
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();

        sll.append(5);
        sll.append(10);
        sll.append(20);

        sll.Enqueue(13);
        assertEquals(Integer.valueOf(13),sll.head.next.next.next.data);

        sll.Enqueue(25);
        assertEquals(Integer.valueOf(25),sll.head.next.next.next.next.data);

    }

    @Test
    public void deQueue(){
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();

        sll.append(5);
        sll.append(10);
        sll.append(20);

        Node<Integer> x = sll.Dequeue();
        assertEquals(Integer.valueOf(5),x.data);
        assertEquals(Integer.valueOf(10),sll.head.data);

        x = sll.Dequeue();
        assertEquals(Integer.valueOf(10),x.data);
        assertEquals(Integer.valueOf(20),sll.head.data);
    }
}
