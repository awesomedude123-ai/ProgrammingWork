import org.junit.Test;

import static org.junit.Assert.*;

public class MaxHeapTest {
    @Test
    public void testInsert(){
        MaxHeap<Integer> maxH = new MaxHeap<>();
        maxH.insert(0);
        maxH.insert(100);
        maxH.insert(40);
        maxH.insert(1);
        maxH.insert(75);
        maxH.insert(50);

        assertEquals("[100, 75, 50, 0, 1, 40]",maxH.maxHeap.toString());

    }

    @Test
    public void testHeapifyUp(){
        MaxHeap<Integer> maxH = new MaxHeap<>();
        maxH.maxHeap.add(11);
        maxH.maxHeap.add(5);
        maxH.maxHeap.add(8);
        maxH.maxHeap.add(3);
        maxH.maxHeap.add(4);
        maxH.maxHeap.add(15);
        maxH.heapSize=6;

        maxH.heapifyUp(5);
        assertEquals(Integer.valueOf(15),maxH.maxHeap.get(0));

    }

    @Test
    public void testHeapifyDown(){
        MaxHeap<Integer> maxH = new MaxHeap<>();
        maxH.maxHeap.add(1);
        maxH.maxHeap.add(11);
        maxH.maxHeap.add(5);
        maxH.maxHeap.add(8);
        maxH.maxHeap.add(3);
        maxH.maxHeap.add(4);

        maxH.heapSize=6;
        maxH.heapifyDown(0);
        assertEquals(Integer.valueOf(11),maxH.maxHeap.get(0));
        assertEquals("[11, 8, 5, 1, 3, 4]",maxH.maxHeap.toString());
    }

    @Test
    public void testExtract() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.maxHeap.add(11);
        maxHeap.maxHeap.add(5);
        maxHeap.maxHeap.add(8);
        maxHeap.maxHeap.add(3);
        maxHeap.maxHeap.add(4);
        maxHeap.maxHeap.add(1);

        maxHeap.heapSize=6;
        assertEquals(Integer.valueOf(11),maxHeap.extract());
        assertEquals(5,maxHeap.heapSize);
        assertEquals(Integer.valueOf(8),maxHeap.extract());
        assertEquals(Integer.valueOf(5),maxHeap.extract());
        assertEquals(Integer.valueOf(4),maxHeap.extract());
        assertEquals(Integer.valueOf(3),maxHeap.extract());
        assertEquals(Integer.valueOf(1),maxHeap.extract());
        assertEquals(null,maxHeap.extract());
    }

    @Test
    public void testHeapSort() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Integer[] heap = new Integer[9];
        heap[0] = 5;
        heap[1] = 8;
        heap[2] = 1;
        heap[3] = 3;
        heap[4] = 4;
        heap[5] = 7;
        heap[6] = 11;
        heap[7] = 6;
        heap[8] = 9;

        Integer[] sortedHeap = maxHeap.sort(heap);
        assertEquals(Integer.valueOf(1),sortedHeap[0]);
        assertEquals(Integer.valueOf(3),sortedHeap[1]);
        assertEquals(Integer.valueOf(4),sortedHeap[2]);
        assertEquals(Integer.valueOf(5),sortedHeap[3]);
        assertEquals(Integer.valueOf(6),sortedHeap[4]);
        assertEquals(Integer.valueOf(7),sortedHeap[5]);
        assertEquals(Integer.valueOf(8),sortedHeap[6]);
        assertEquals(Integer.valueOf(9),sortedHeap[7]);
        assertEquals(Integer.valueOf(11),sortedHeap[8]);

        Integer[] heap1 = new Integer[5];
        heap[0] = 5;
        heap[1] = 1;
        heap[2] = 3;
        heap[3] = 3;
        heap[4] = 4;

        Integer[] sortedHeap1 = maxHeap.sort(heap);
        assertEquals(Integer.valueOf(1),sortedHeap[0]);
        assertEquals(Integer.valueOf(3),sortedHeap[1]);
        assertEquals(Integer.valueOf(3),sortedHeap[2]);
        assertEquals(Integer.valueOf(4),sortedHeap[3]);
        assertEquals(Integer.valueOf(5),sortedHeap[4]);
    }


}
