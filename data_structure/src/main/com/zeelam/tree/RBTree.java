package com.zeelam.tree;

import java.util.Comparator;

public class RBTree<T> extends BBST<T> {
  private static final boolean RED = false;
  private static final boolean BLACK = true;

  public RBTree() {
    this(null);
  }

  public RBTree(Comparator<T> comparator) {
    super(comparator);
  }

  private Node<T> color(Node<T> node, boolean color) {
    if (node == null) return node;
    ((RBNode<T>) node).color = color;
    return node;
  }

  private Node<T> red(Node<T> node) {
    return color(node, RED);
  }

  private Node<T> black(Node<T> node) {
    return color(node, BLACK);
  }

  private boolean colorOf(Node<T> node) {
    return node == null ? BLACK : ((RBNode<T>) node).color;
  }

  private boolean isRed(Node<T> node) {
    return colorOf(node) == RED;
  }

  private boolean isBlack(Node<T> node)

  {
    return colorOf(node) == BLACK;
  }

  @Override
  protected void afterAdd(Node<T> node) {
    Node<T> parent = node.parent;

    if (parent == null) {
      black(node);
      return;
    }

    if (isBlack(parent)) return;

    Node<T> uncle = parent.sibling();
    Node<T> grand = parent.parent;
    if (isRed(uncle)) {
      black(parent);
      black(uncle);
      afterAdd(red(grand));
      return;
    }

    if (parent.isLeftChild()) {
      red(grand);
      if (node.isLeftChild()) { // LL
        black(parent);
      } else { // LR
        black(node);
        rotateLeft(parent);
      }
      rotateRight(grand);
    } else {
      red(grand);
      if (node.isRightChild()) { // RR
        black(parent);
      } else { // RL
        black(node);
        rotateRight(parent);
      }
      rotateLeft(grand);
    }

  }

  @Override
  protected void afterRemove(Node<T> node) {

  }

  @Override
  protected Node<T> createNode(T element, Node<T> parent) {
    return new RBNode<>(element, parent);
  }

  private static class RBNode<T> extends Node<T> {
    boolean color = RED;
    public RBNode(T element, Node<T> parent) {
      super(element, parent);
    }

    @Override
    public String toString() {
      String str = "";
      if (color == RED) {
        str = "R_";
      }
      return str + element.toString();
    }
  }

}
