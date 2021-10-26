package com.zeelam.tree;

import com.zeelam.util.printer.BinaryTrees;
import org.junit.Test;

public class TestAVLTree {

    @Test
    public void testAVLTreeAdd() {
        Integer[] dataArr = new Integer[] {85, 19, 69, 3, 7, 99, 95, 2, 1, 70, 44, 58, 11, 21, 14, 93, 57, 4, 56};
        AVLTree<Integer> avlTree = new AVLTree<>();
        for (Integer data: dataArr) {
            avlTree.add(data);
        }
        BinaryTrees.println(avlTree);
    }

    @Test
    public void testAVLTreeRemove() {
        Integer[] dataArr = new Integer[] {85, 19, 69, 3, 7, 99, 95, 2, 1, 70, 44, 58, 11, 21, 14, 93, 57, 4, 56};
        AVLTree<Integer> avlTree = new AVLTree<>();
        for (Integer data : dataArr) {
            avlTree.add(data);
        }
        BinaryTrees.println(avlTree);
        for (Integer data : dataArr) {
            avlTree.remove(data);
            BinaryTrees.println(avlTree);
        }
    }

}
