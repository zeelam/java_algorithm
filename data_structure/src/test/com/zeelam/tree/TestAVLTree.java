package com.zeelam.tree;

import com.zeelam.util.printer.BinaryTrees;
import org.junit.Test;

public class TestAVLTree {

    @Test
    public void testAVLTree1() {
        Integer[] data = new Integer[] {7, 8, 9};
        AVLTree<Integer> avlTree = new AVLTree<>();
        for (Integer datum : data) {
            avlTree.add(datum);
        }
        BinaryTrees.println(avlTree);
    }

}
