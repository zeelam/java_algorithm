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

    /**
     * preorder
     * root->left->right
     */
    public void preorderTraversal(Visitor<T> visitor){
        if (visitor == null) return;
        preorderTraversal(root, visitor);
    }

    private void preorderTraversal(Node<T> node, Visitor<T> visitor){
        if (node == null || visitor.isStop) return;
        visitor.isStop = visitor.visit(node.element);
        preorderTraversal(node.left, visitor);
        preorderTraversal(node.right, visitor);
    }

    /**
     * inorder
     * left->root->right
     */
    public void inorderTraversal(Visitor<T> visitor){
        if (visitor == null) return;
        inorderTraversal(root, visitor);
    }

    private void inorderTraversal(Node<T> node, Visitor<T> visitor){
        if (node == null || visitor.isStop) return;
        inorderTraversal(node.left, visitor);
        if (visitor.isStop) return;
        visitor.isStop = visitor.visit(node.element);
        inorderTraversal(node.right, visitor);
    }

    /**
     * postorder
     * left->right->root
     */
    public void postorderTraversal(Visitor<T> visitor){
        if (visitor == null) return;
        postorderTraversal(root, visitor);
    }

    private void postorderTraversal(Node<T> node, Visitor<T> visitor) {
        if (node == null || visitor.isStop) return;
        postorderTraversal(node.left, visitor);
        postorderTraversal(node.right, visitor);
        if (visitor.isStop) return;
        visitor.isStop = visitor.visit(node.element);
    }

    /**
     * Level order traversal
     */
    public void levelOrderTraversal(Visitor<T> visitor){
        if (root == null) return;
        Queue<Node<T>> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            Node<T> node = nodes.poll();
            if (visitor.visit(node.element)) return;
            if (node.left != null) nodes.offer(node.left);
            if (node.right != null) nodes.offer(node.right);
        }
    }

    private void elementNotNullCheck(T element) {
        if (element == null) throw new IllegalArgumentException("element cannot be null");
    }

    public static abstract class Visitor<T>{
        boolean isStop;
        abstract boolean visit(T element);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb, "");
        return sb.toString();
    }

    private void toString(Node<T> node, StringBuilder sb, String prefix) {
        if (node == null) return;
        sb.append(prefix).append(node.element).append("\n");
        toString(node.left, sb, prefix + "L---");
        toString(node.right, sb, prefix + "R---");
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
