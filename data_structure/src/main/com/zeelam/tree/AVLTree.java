package com.zeelam.tree;

import com.zeelam.tree.BinarySearchTree;

import java.util.Comparator;

public class AVLTree<T> extends BinarySearchTree<T> {

    public AVLTree(){
        this(null);
    }

    public AVLTree(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<T> node) {
        while ((node = node.parent) != null)
            if (isBalanced(node)) {
                updateHeight(node);
            } else {
                balance(node);
                break;
            }
    }

    @Override
    protected Node<T> createNode(T element, Node<T> parent) {
        return new AVLNode<>(element, parent);
    }

    private void balance(Node<T> grand){
        Node<T> parent = ((AVLNode<T>) grand).tallerChild();
        Node<T> node = ((AVLNode<T>) parent).tallerChild();
        if (parent.isLeftChild()) {
            if (node.isLeftChild()) {
                // LL
                rotateRight(grand);
            } else {
                // LR
                rotateLeft(parent);
                rotateRight(grand);
            }
        } else {
            if (node.isRightChild()) {
                // RR
                rotateLeft(grand);
            } else {
                // RL
                rotateRight(parent);
                rotateLeft(grand);
            }
        }
    }

    private void rotateLeft(Node<T> grand) {
        Node<T> parent = grand.right;
        Node<T> child = parent.left;
        grand.right = child;
        parent.left = grand;

        afterRotate(grand, parent, child);
    }

    private void rotateRight(Node<T> grand) {
        Node<T> parent = grand.left;
        Node<T> child = parent.right;
        grand.left = child;
        parent.right = grand;

        afterRotate(grand, parent, child);
    }

    private void afterRotate(Node<T> grand, Node<T> parent, Node<T> child) {
        // set parents
        if (child != null) {
            child.parent = grand;
        }
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()){
            grand.parent.right = parent;
        } else {
            root = parent;
        }
        grand.parent = parent;

        // update height for each node
        updateHeight(grand);
        updateHeight(parent);
    }

    private boolean isBalanced(Node<T> node) {
        return Math.abs(((AVLNode<T>) node).balanceFactor()) <= 1;
    }

    private void updateHeight(Node<T> node) {
        ((AVLNode<T>) node).updateHeight();
    }

    private static class AVLNode<T> extends Node<T> {

        int height = 1;

        public AVLNode(T element, Node<T> parent) {
            super(element, parent);
        }

        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<T>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<T>)right).height;
            return leftHeight - rightHeight;
        }

        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AVLNode<T>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<T>)right).height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }

        public Node<T> tallerChild(){
            int leftHeight = left == null ? 0 : ((AVLNode<T>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<T>)right).height;
            if (leftHeight > rightHeight) return left;
            if (leftHeight < rightHeight) return right;
            return isLeftChild() ? left : right;
        }

    }

}
