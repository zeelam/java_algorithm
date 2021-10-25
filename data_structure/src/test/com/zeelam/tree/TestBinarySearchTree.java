package com.zeelam.tree;

import com.zeelam.util.Person;
import com.zeelam.util.PersonWithCom;
import com.zeelam.util.printer.BinaryTrees;
import com.zeelam.tree.BinarySearchTree.Visitor;
import org.junit.Test;

public class TestBinarySearchTree {

    @Test
    public void testBst1() {
        Integer[] data = new Integer[] {8, 7, 9, 10, 11, 12, 3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer datum : data) {
            bst.add(datum);
        }
        BinaryTrees.println(bst);
    }

    @Test
    public void testBst2() {
        Person[] data = new Person[]{ new Person(10), new Person(20), new Person(8)};
        BinarySearchTree<Person> bst = new BinarySearchTree<>((o1, o2) -> o1.getAge() - o2.getAge());
        for (Person datum : data) {
            bst.add(datum);
        }
        BinaryTrees.println(bst);
    }

    @Test
    public void testBstUsingComparable() {
        PersonWithCom[] data = new PersonWithCom[]{ new PersonWithCom(10), new PersonWithCom(20), new PersonWithCom(8)};
        BinarySearchTree<Person> bst = new BinarySearchTree<>();
        for (PersonWithCom person : data) {
            bst.add(person);
        }
        BinaryTrees.println(bst);
    }

    @Test
    public void testBstPreorderTraversal(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < 10; i++) {
            bst.add((int) (Math.random() * 100));
        }
        BinaryTrees.println(bst);
        bst.preorderTraversal(new Visitor<Integer>() {
            int count = 0;
            @Override
            public boolean visit(Integer element) {
                System.out.print("_" + element + "_");
                return ++count >= 3;
            }
        });
        System.out.println();
    }

    @Test
    public void testBstInorderTraversal(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < 10; i++) {
            bst.add((int) (Math.random() * 100));
        }
        BinaryTrees.println(bst);
        bst.inorderTraversal(new Visitor<Integer>() {
            int count = 0;
            @Override
            public boolean visit(Integer element) {
                System.out.print("_" + element + "_");
                return ++count >= 3;
            }
        });
        System.out.println();
    }

    @Test
    public void testBstPostorderTraversal(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < 10; i++) {
            bst.add((int) (Math.random() * 100));
        }
        BinaryTrees.println(bst);
        bst.postorderTraversal(new Visitor<Integer>() {
            int count = 0;
            @Override
            public boolean visit(Integer element) {
                System.out.print("_" + element + "_");
                return ++count >= 3;
            }
        });
        System.out.println();
    }

    @Test
    public void testBstLevelOrderTraversal(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < 10; i++) {
            bst.add((int) (Math.random() * 100));
        }
        BinaryTrees.println(bst);
        bst.levelOrderTraversal(new Visitor<Integer>() {
            int count = 0;
            @Override
            public boolean visit(Integer element) {
                System.out.print("_" + element + "_");
                return ++count >= 3;
            }
        });
        System.out.println();
    }

    @Test
    public void testBstToString(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < 10; i++) {
            bst.add((int) (Math.random() * 100));
        }
        System.out.println(bst);
    }

    @Test
    public void testBstHeight(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < 10; i++) {
            bst.add((int) (Math.random() * 100));
        }
        BinaryTrees.println(bst);
        System.out.println(bst.height());
    }

    @Test
    public void testBstCompleted(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(7);
        bst.add(4);
        bst.add(9);
        bst.add(2);
        bst.add(5);
        BinaryTrees.println(bst);
        System.out.println(bst.isComplete());

        bst = new BinarySearchTree<>();
        bst.add(7);
        bst.add(5);
        bst.add(2);
        bst.add(9);
        bst.add(4);
        BinaryTrees.println(bst);
        System.out.println(bst.isComplete());

    }

    @Test
    public void testBstRemove(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(7);
        bst.add(4);
        bst.add(9);
        bst.add(2);
        bst.add(5);
        BinaryTrees.println(bst);

        bst.remove(4);
        bst.remove(2);
        BinaryTrees.println(bst);

        bst = new BinarySearchTree<>();
        bst.add(7);
        bst.add(4);
        bst.add(9);
        bst.add(2);
        bst.add(5);
        BinaryTrees.println(bst);

        bst.remove(9);
        bst.remove(2);
        BinaryTrees.println(bst);

    }

    @Test
    public void testBstContains(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(7);
        bst.add(4);
        bst.add(9);
        bst.add(2);
        bst.add(5);
        BinaryTrees.println(bst);
        System.out.println(bst.contains(9));
    }

}
