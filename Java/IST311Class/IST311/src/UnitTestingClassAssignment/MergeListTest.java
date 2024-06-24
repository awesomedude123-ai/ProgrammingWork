package UnitTestingClassAssignment;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MergeListTest {

    @Test
    public void testEmptyLists() {
        MergeList m1 = new MergeList();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> l1l2 = m1.mergeList(list, list2);
        assertTrue(l1l2.isEmpty());
    }


    @Test
    public void testSmallList() {
        MergeList m1 = new MergeList();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list.add(50);
        list.add(60);
        list.add(70);
        list2.add(45);
        list2.add(65);
        list2.add(90);
        ArrayList<Integer> l1l2 = m1.mergeList(list, list2);
        assertEquals("{45, 50, 60, 65, 70, 90, }", m1.toString());
    }

    @Test
    public void testMergeOneListItem(){
        MergeList m1 = new MergeList();
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        l1.add(15);
        l2.add(30);
        ArrayList<Integer> l3 = m1.mergeList(l1, l2);
        assertEquals("{15, 30, }",m1.toString());
    }

    @Test
    public void testMergeOneSmallAndOneBigList(){
        MergeList m1 = new MergeList();
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        l1.add(15);
        l2.add(5);
        l2.add(7);
        l2.add(9);
        l2.add(11);
        l2.add(13);
        l2.add(20);
        l2.add(25);
        l2.add(28);
        l2.add(30);
        l2.add(40);
        ArrayList<Integer> l3 = m1.mergeList(l1, l2);
        assertEquals("{5, 7, 9, 11, 13, 15, 20, 25, 28, 30, 40, }",m1.toString());
    }

    @Test
    public void mergedUnsrotedList1(){
        MergeList m1 = new MergeList();
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        l1.add(90);
        l1.add(80);
        l1.add(69);
        l1.add(50);
        l1.add(20);
        l2.add(101);
        ArrayList<Integer> l3 = m1.mergeList(l1,l2);
        assertEquals("{20, 50, 69, 80, 90, 101, }",m1.toString());
    }

    @Test
    public void mergedUnsrotedList2(){
        MergeList m1 = new MergeList();
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        l1.add(5);
        l1.add(-13);
        l1.add(7);
        l1.add(11);
        l2.add(12);
        l2.add(-3);
        l2.add(0);
        ArrayList<Integer> l3 = m1.mergeList(l1,l2);
        assertEquals("{-13, -3, 0, 5, 7, 11, 12, }",m1.toString());
    }




}
