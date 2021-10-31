package com.zeelam.tree;

import com.zeelam.util.printer.BinaryTrees;
import org.junit.Test;

public class TestRBTree {

    @Test
    public void testRBTreeAdd() {
        Integer[] dataArr = new Integer[] {28, 19, 29, 26, 59, 1, 98, 31, 93, 16, 82, 100, 39, 90, 2, 64, 15, 80, 13};
        RBTree<Integer> rbTree = new RBTree<>();
        for (Integer data: dataArr) {
            rbTree.add(data);
        }
        BinaryTrees.println(rbTree);
    }

    @Test
    public void testAVLTreeRemove() {
        Integer[] dataArr = new Integer[] {28, 19, 29, 26, 59, 1, 98, 31, 93, 16, 82, 100, 39, 90, 2, 64, 15, 80, 13};
        RBTree<Integer> rbTree = new RBTree<>();
        for (Integer data : dataArr) {
            rbTree.add(data);
        }
        BinaryTrees.println(rbTree);
        for (Integer data : dataArr) {
            rbTree.remove(data);
            BinaryTrees.println(rbTree);
        }
    }

}
