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
    private int heightRecursion(Node<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(heightRecursion(node.left), heightRecursion(node.right));
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
        } else if (node.parent == null) {
            root = null;
        } else {
            if (node == node.parent.left) node.parent.left = null;
            else node.parent.right = null;
        }
    }

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

    private void elementNotNullCheck(T element) {
        if (element == null) throw new IllegalArgumentException("element cannot be null");
    }

    private Node<T> predecessor(Node<T> node) {
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

    private Node<T> successor(Node<T> node) {
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

        public boolean isLeaf(){
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

    }

}
