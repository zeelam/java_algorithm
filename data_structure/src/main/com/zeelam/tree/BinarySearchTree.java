package com.zeelam.tree;

import java.util.Comparator;

public class BinarySearchTree<T> extends BinaryTree<T>  {

    private Comparator<T> comparator;

    public BinarySearchTree(){
        this(null);
    }

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void add(T element){
        elementNotNullCheck(element);
        if (root == null) {
            root = createNode(element, null);
            size++;
            afterAdd(root);
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
        Node<T> newNode = createNode(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
        afterAdd(newNode);
    }

    protected void afterAdd(Node<T> node) {}

    private int compare(T element1, T element2) {
        if (comparator != null){
            return comparator.compare(element1, element2);
        }
        return ((Comparable<T>)element1).compareTo(element2);
    }

    public void remove(T element) {
        remove(node(element));
    }

    private void remove(Node<T> node){
        if (node == null) return;
        size--;
        if (node.hasTwoChildren()) {
            Node<T> successor = successor(node);
            node.element = successor.element;
            node = successor;
        }
        Node<T> replacement = node.left != null ? node.left : node.right;
        if (replacement != null) {
            replacement.parent = node.parent;
            if (node.parent == null) root = replacement;
            else if (node == node.parent.left) node.parent.left = replacement;
            else node.parent.right = replacement;
            afterRemove(replacement);
        } else if (node.parent == null) {
            root = null;
            afterRemove(node);
        } else {
            if (node == node.parent.left) node.parent.left = null;
            else node.parent.right = null;
            afterRemove(node);
        }
    }

    protected void afterRemove(Node<T> node) {}

    private Node<T> node(T element) {
        Node<T> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    public boolean contains(T element) {
        return node(element) != null;
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

}
