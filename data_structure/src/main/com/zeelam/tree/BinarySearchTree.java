package com.zeelam.tree;

import com.zeelam.util.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T> implements BinaryTreeInfo {

    private int size;
    private Node<T> root;
    private Comparator<T> comparator;

    public BinarySearchTree(){
        this(null);
    }

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){

    }

    public void add(T element){
        elementNotNullCheck(element);
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        Node<T> parent = root;
        Node<T> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0){
                node = node.right;
            } else if(cmp < 0) {
                node = node.left;
            } else {
                node.element = element;
                return;
            }
        }
        Node<T> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    private int compare(T element1, T element2) {
        if (comparator != null){
            return comparator.compare(element1, element2);
        }
        return ((Comparable<T>)element1).compareTo(element2);
    }

    public void remove(T element) {

    }

    public boolean contains(T element) {
        return false;
    }

    public void preorderTraversal(){
        preorderTraversal(root);
    }

    private void preorderTraversal(Node<T> node){
        if (node == null) return;
        System.out.println(node.element);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public void inorderTraversal(){
        inorderTraversal(root);
    }

    private void inorderTraversal(Node<T> node){
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.println(node.element);
        inorderTraversal(node.right);
    }

    public void postorderTraversal(){
        postorderTraversal(root);
    }

    private void postorderTraversal(Node<T> node) {
        if (node == null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.element);
    }

    public void levelOrderTraversal(){
        if (root == null) return;
        Queue<Node<T>> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            Node<T> node = nodes.poll();
            System.out.println(node.element);
            if (node.left != null) nodes.offer(node.left);
            if (node.right != null) nodes.offer(node.right);
        }
    }

    private void elementNotNullCheck(T element) {
        if (element == null) throw new IllegalArgumentException("element cannot be null");
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<T>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<T>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node<T> myNode = ((Node<T>) node);
        String parentStr = myNode.parent == null ? "null" : myNode.parent.element.toString();
        return "p(" + parentStr + ")_" + "v(" + myNode.element + ")";
    }

    private static class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;
        Node<T> parent;

        public Node(T element, Node<T> parent){
            this.element = element;
            this.parent = parent;
        }

    }


}
