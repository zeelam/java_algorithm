package com.zeelam.tree;

import com.zeelam.util.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Basic class for binary tree
 */
public class BinaryTree<T> implements BinaryTreeInfo {

    protected int size;
    protected Node<T> root;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isComplete() {
        if (root == null) return false;

        Queue<Node<T>> nodes = new LinkedList<>();
        nodes.offer(root);
        boolean leaf = false;
        while (!nodes.isEmpty()) {
            Node<T> node = nodes.poll();

            if (leaf && !node.isLeaf()) return false;

            if (node.left != null) {
                nodes.offer(node.left);
            } else if (node.right != null) {
                return false;
            }

            if (node.right != null) {
                nodes.offer(node.right);
            } else {
                leaf = true;
            }
        }
        return true;
    }

//    public boolean isComplete() {
//        if (root == null) return false;
//
//        Queue<Node<T>> nodes = new LinkedList<>();
//        nodes.offer(root);
//        boolean leaf = false;
//
//        while (!nodes.isEmpty()) {
//            Node<T> node = nodes.poll();
//            if (leaf && !node.isLeaf()) return false;
//            if (node.hasTwoChildren()) {
//                nodes.offer(node.left);
//                nodes.offer(node.right);
//            } else if (node.left == null && node.right != null) {
//                return false;
//            } else {
//                leaf = true;
//                if (node.left != null) nodes.offer(node.left);
//            }
//        }
//        return true;
//    }

    /**
     * get the height of tree by iteration
     * @return int
     */
    public int height() {
        if (root == null) return 0;
        int height = 0;
        int levelSize = 1;

        // level order here
        Queue<Node<T>> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            Node<T> node = nodes.poll();
            levelSize--;
            if (node.left != null) nodes.offer(node.left);
            if (node.right != null) nodes.offer(node.right);
            if (levelSize == 0) {
                levelSize = nodes.size();
                height++;
            }
        }
        return height;
    }

    /**
     * get the height of node by recursion
     * @param node selected node
     * @return int
     */
    public int heightRecursion(Node<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(heightRecursion(node.left), heightRecursion(node.right));
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

    public static abstract class Visitor<T>{
        boolean isStop;
        abstract boolean visit(T element);
    }

    protected Node<T> predecessor(Node<T> node) {
        if (node == null) return null;
        Node<T> p = node.left;
        // predecessor in the left tree
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }

    protected Node<T> successor(Node<T> node) {
        if (node == null) return null;
        Node<T> p = node.right;
        // successor in the right tree
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    protected void elementNotNullCheck(T element) {
        if (element == null) throw new IllegalArgumentException("element cannot be null");
    }

    protected Node<T> createNode(T element, Node<T> parent) {
        return new Node<>(element, parent);
    }

    protected static class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;
        Node<T> parent;

        public Node(T element, Node<T> parent){
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf(){
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        public boolean isLeftChild(){
            return parent != null && this == parent.left;
        }

        public boolean isRightChild(){
            return parent != null && this == parent.right;
        }

        public Node<T> sibling() {
            if (isLeftChild()) {
                return parent.right;
            }
            if (isRightChild()) {
                return parent.left;
            }
            return null;
        }

        @Override
        public String toString() {
            String parentStr = parent == null ? "null" : parent.element.toString();
            return "p(" + parentStr + ")_" + "v(" + element + ")";
        }

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
        return node;
    }

}
