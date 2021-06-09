package com.zeelam.tree;

import com.zeelam.util.Person;
import com.zeelam.util.PersonWithCom;
import com.zeelam.util.printer.BinaryTrees;
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
        for (int i = 0; i < 30; i++) {
            bst.add((int) (Math.random() * 100));
        }
        BinaryTrees.println(bst);
        bst.preorderTraversal();
    }

}
