package com.zeelam.linearList;

import org.junit.Assert;
import org.junit.Test;

public class TestLinearList {

    @Test
    public void testArrayList(){
        List<Integer> list = new ArrayList<>();
        testList(list);
    }

    @Test
    public void testLinkedList(){
        List<Integer> list = new LinkedList<>();
        testList(list);
    }

    @Test
    public void testJosephus() {
        com.zeelam.linearList.circularLinkedList.doubly.LinkedList<Integer> circularLinkedList = new com.zeelam.linearList.circularLinkedList.doubly.LinkedList<>();
        for (int i = 1; i <= 8; i++) {
            circularLinkedList.add(i);
        }
        circularLinkedList.reset();
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        while (!circularLinkedList.isEmpty()){
            circularLinkedList.next();
            circularLinkedList.next();
            list.add(circularLinkedList.remove());
        }
        Assert.assertTrue(list.get(0) == 3);
        Assert.assertTrue(list.get(1) == 6);
        Assert.assertTrue(list.get(2) == 1);
        Assert.assertTrue(list.get(3) == 5);
        Assert.assertTrue(list.get(4) == 2);
        Assert.assertTrue(list.get(5) == 8);
        Assert.assertTrue(list.get(6) == 4);
        Assert.assertTrue(list.get(7) == 7);
    }

    private void testList(List<Integer> list){
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(2);
        list.add(list.size(), 100);
        Assert.assertTrue(list.get(0) == 0);
        Assert.assertTrue(list.get(1) == 1);
        Assert.assertTrue(list.get(2) == 3);
        Assert.assertTrue(list.get(3) == 4);
        Assert.assertTrue(list.get(4) == 100);
    }

}
