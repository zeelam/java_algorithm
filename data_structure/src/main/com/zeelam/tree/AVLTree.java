package com.zeelam.tree;

import java.util.Comparator;

public class AVLTree<T> extends BBST<T> {

    public AVLTree(){
        this(null);
    }

    public AVLTree(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<T> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                updateHeight(node);
            } else {
                balance(node);
                break;
            }
        }
    }

    @Override
    protected void afterRemove(Node<T> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                updateHeight(node);
            } else {
                balance(node);
            }
        }
    }

    @Override
    protected Node<T> createNode(T element, Node<T> parent) {
        return new AVLNode<>(element, parent);
    }

    @Override
    protected void afterRotate(Node<T> grand, Node<T> parent, Node<T> child) {
        super.afterRotate(grand, parent, child);
        // update height for each node
        updateHeight(grand);
        updateHeight(parent);
    }

    @Override
    protected void unifyRotate(Node<T> r, Node<T> a, Node<T> b, Node<T> c, Node<T> d, Node<T> e, Node<T> f, Node<T> g) {
        super.unifyRotate(r, a, b, c, d, e, f, g);
        updateHeight(b);
        updateHeight(f);
        updateHeight(d);
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

    private void balanceByUniRotation(Node<T> grand){
        Node<T> parent = ((AVLNode<T>) grand).tallerChild();
        Node<T> node = ((AVLNode<T>) parent).tallerChild();
        if (parent.isLeftChild()) {
            if (node.isLeftChild()) {
                // LL
                unifyRotate(grand,
                        node.left, node, node.right,
                        parent,
                        parent.right, grand, grand.right);
            } else {
                // LR
                unifyRotate(grand,
                        parent.left, parent, node.left,
                        node,
                        node.right, grand, grand.right);
            }
        } else {
            if (node.isRightChild()) {
                // RR
                unifyRotate(grand,
                        grand.left, grand, parent.left,
                        parent,
                        node.left, node, node.right);
            } else {
                // RL
                unifyRotate(grand,
                        grand.left, grand, node.left,
                        node,
                        node.right, parent, parent.right);
            }
        }
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

        @Override
        public String toString() {
            String parentStr = parent == null ? "null" : parent.element.toString();
            return "h(" + height + ")_" + "p(" + parentStr + ")_" + "v(" + element + ")";
        }
    }

}
