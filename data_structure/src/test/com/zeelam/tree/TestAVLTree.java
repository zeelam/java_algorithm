package com.zeelam.tree;

import com.zeelam.util.printer.BinaryTrees;
import org.junit.Test;

public class TestAVLTree {

    @Test
    public void testAVLTree1() {
        Integer[] data = new Integer[] {85, 19, 69, 3, 7, 99, 95, 2, 1, 70, 44, 58, 11, 21, 14, 93, 57, 4, 56};
        AVLTree<Integer> avlTree = new AVLTree<>();
        for (Integer datum : data) {
            avlTree.add(datum);
        }
        BinaryTrees.println(avlTree);
    }

}
