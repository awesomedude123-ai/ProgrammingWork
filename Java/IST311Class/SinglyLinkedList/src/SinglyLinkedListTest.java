import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    @Test
    public void testConstructor(){
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        assertNull(sll.head);
    }

    @Test
    public void testAppendEmpty(){
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.append(Integer.valueOf(5));
        assertEquals(Integer.valueOf(5),sll.head.val);
    }

    @Test
    public void testAppendNumeric(){
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.append(Integer.valueOf(5));
        sll.append(Integer.valueOf(7));
        sll.append(Integer.valueOf(10));
        assertEquals(Integer.valueOf(7),sll.head.next.val);
        assertEquals(Integer.valueOf(10),sll.head.next.next.val);
    }

    @Test
    public void testToString() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        assertNull(sll.head);
        assertEquals("NULL",sll.toString());
        sll.append(1);
        assertEquals("1 -> NULL",sll.toString());
        assertEquals(Integer.valueOf(1),sll.head.val);
        sll.append(2);
        assertEquals("1 -> 2 -> NULL",sll.toString());
        sll.append(3);
        assertEquals("1 -> 2 -> 3 -> NULL",sll.toString());
        assertEquals(Integer.valueOf(2),sll.head.next.val);
        assertEquals(Integer.valueOf(3),sll.head.next.next.val);
        sll.append(4);
        assertEquals("1 -> 2 -> 3 -> 4 -> NULL",sll.toString());
    }

    @Test
    public void testEmptyContains() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        assertEquals(false,sll.contains(1));
    }

    @Test
    public void testHeadContains() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.append(1);
        assertEquals(true,sll.contains(1));
    }

    @Test
    public void testTailContains() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.append(1);
        sll.append(2);
        sll.append(3);
        assertEquals(true,sll.contains(3));
    }

    @Test
    public void testContains() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.append(1);
        sll.append(2);
        sll.append(3);
        assertFalse(sll.contains(4));
        assertTrue(sll.contains(3));
        assertTrue(sll.contains(2)); //Tests Middle Contains
        assertTrue(sll.contains(1));
    }

    @Test
    public void testEmptyDelete() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        assertNull(sll.delete(1));
    }

    @Test
    public void testHeadDelete() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.append(1);
        assertEquals(Integer.valueOf(1),sll.delete(1).val);
    }

    @Test
    public void testEndDelete() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.append(1);
        sll.append(2);
        assertEquals(Integer.valueOf(2),sll.delete(2).val);
        assertEquals("1 -> NULL", sll.toString());
    }

    @Test
    public void testMiddleDelete() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.append(1);
        sll.append(2);
        sll.append(3);
        sll.append(5);
        assertNull(sll.delete(4));
        assertEquals(Integer.valueOf(1),sll.delete(1).val);

        assertEquals(Integer.valueOf(3),sll.delete(3).val);
    }


    //Tests Middle Append
    @Test
    public void testInsert() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.append(1);
        sll.append(2);
        sll.append(3);
        assertNull(sll.insert(4,5));
        sll.insert(1,4);
        assertEquals(Integer.valueOf(4),sll.head.next.val);
    }

    @Test
    public void testGetIndex() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.append(1);
        sll.append(2);
        sll.append(3);
        assertEquals(-1,sll.getIndex(4));
        assertEquals(0,sll.getIndex(1));
    }

    @Test
    public void testPopStack() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.append(1);
        sll.append(2);
        sll.append(3);
        sll.popStack();
        assertEquals(Integer.valueOf(2),sll.head.val);
        assertEquals("2 -> 3 -> NULL",sll.toString());
    }

    @Test
    public void testPushStack() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.append(1);
        sll.append(2);
        sll.append(3);
        sll.pushStack(4);
        assertEquals("4 -> 1 -> 2 -> 3 -> NULL",sll.toString());
    }

    @Test
    public void testDequeue() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        assertNull(sll.dequeue());
        sll.append(1);
        assertEquals(Integer.valueOf(1),sll.dequeue().val);
        assertNull(sll.head);
    }

    @Test
    public void testEnqueue() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.append(1);
        sll.append(2);
        sll.queue(3);
        assertEquals(Integer.valueOf(3),sll.head.next.next.val);
        assertEquals("1 -> 2 -> 3 -> NULL",sll.toString());
        sll.queue(4);
        assertEquals(Integer.valueOf(4),sll.head.next.next.next.val);
        assertEquals("1 -> 2 -> 3 -> 4 -> NULL",sll.toString());
    }
}
